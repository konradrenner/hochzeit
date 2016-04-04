/*
 * Copyright (C) 2015 Konrad Renner
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package at.kuk.hochzeit.hochzeit.rest;

import at.kuk.hochzeit.hochzeit.HochzeitLogger;
import at.kuk.hochzeit.hochzeit.SessionTimestamp;
import at.kuk.hochzeit.hochzeit.web.UserMapping;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author Konrad Renner
 */
@Path("upload")
@Stateless
@LocalBean
public class UploadResource {

    @Resource
    private SessionContext context;

    @Inject
    SessionTimestamp tstProvider;

    @Inject
    HochzeitLogger logger;

    @POST
    @Path("images")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(MultipartFormDataInput multipart) {
        try {
            logger.info(getClass(), "upload", "started");

            Map<String, List<InputPart>> formParts = multipart.getFormDataMap();

            List<InputPart> inPart = formParts.get("file");

            java.nio.file.Path newDirectory = Files.createDirectories(Paths.get(System.getProperty("hochzeit.filePath"), UserMapping.resolve(context.getCallerPrincipal()).replaceAll(" ", "_"), tstProvider.getSessionTimestamp().toString()));

            String filename;
            for (InputPart inputPart : inPart) {

                MultivaluedMap<String, String> headers = inputPart.getHeaders();
                filename = parseFileName(headers);
                logger.info(getClass(), "upload", "filename=" + filename);

                try (OutputStream output = Files.newOutputStream(Paths.get(newDirectory.toString(), filename), StandardOpenOption.CREATE_NEW);
                        InputStream input = inputPart.getBody(InputStream.class, null)) {

                    byte[] b = new byte[2048];
                    int length;

                    while ((length = input.read(b)) != -1) {
                        output.write(b, 0, length);
                    }
                }
            }
            return Response.status(200).build();
        } catch (IOException ex) {
            logger.error(getClass(), "upload", ex);
            return Response.status(500).build();
        } finally {
            logger.info(getClass(), "upload", "finished");
        }
    }

    private String parseFileName(MultivaluedMap<String, String> headers) {
        String[] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");
        for (String name : contentDispositionHeader) {

            if ((name.trim().startsWith("filename"))) {

               String[] tmp = name.split("=");

               String fileName = tmp[1].trim().replaceAll("\"", "");

               return fileName;

            }
        }
        return "randomName";
    }
}
