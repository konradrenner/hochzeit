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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.kore.jca.file.FileSource;
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

    @Resource(name = "java:global/jca/FileStore")
    FileSource source;

    public void handleFileUpload(FileUploadEvent event) {
        String filename = event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf(File.pathSeparator) + 1);

        try {
            Path newDirectory = Files.createDirectories(Paths.get(System.getProperty("hochzeit.filePath"), context.getCallerPrincipal().getName(), new Timestamp(System.currentTimeMillis()).toString()));

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(newDirectory.toString(), filename), StandardOpenOption.CREATE_NEW);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(event.getFile().getInputstream()))) {

                String line;
                boolean firstRun = true;
                while ((line = reader.readLine()) != null) {
                    if (firstRun) {
                        firstRun = false;
                        writer.newLine();
                    }
                    writer.write(line);
                }

            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
