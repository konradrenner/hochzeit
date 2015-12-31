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
package at.kuk.hochzeit.hochzeit.web;

import at.kuk.hochzeit.hochzeit.SessionTimestamp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Konrad Renner
 */
@Dependent
@Named
@Stateless
public class UploadBean implements Serializable {

    @Resource
    SessionContext context;

    @Inject
    SessionTimestamp tstProvider;

    public void handleFileUpload(FileUploadEvent event) {
        String filename = event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf(File.pathSeparator) + 1);

        try {
            Path newDirectory = Files.createDirectories(Paths.get(System.getProperty("hochzeit.filePath"), context.getCallerPrincipal().getName(), tstProvider.getSessionTimestamp().toString()));

            try (OutputStream output = Files.newOutputStream(Paths.get(newDirectory.toString(), filename), StandardOpenOption.CREATE_NEW);
                    InputStream input = event.getFile().getInputstream()) {

                byte[] b = new byte[2048];
                int length;

                while ((length = input.read(b)) != -1) {
                    output.write(b, 0, length);
                }

            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (IOException ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
