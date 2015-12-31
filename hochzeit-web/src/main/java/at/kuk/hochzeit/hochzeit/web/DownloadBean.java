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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Konrad Renner
 */
@RequestScoped
@Named
public class DownloadBean {

    private StreamedContent file;

    public StreamedContent getFile() {

        try {
            file = new DefaultStreamedContent(Files.newInputStream(Paths.get(System.getProperty("hochzeit.filePath"), "download", "bilder.zip"), StandardOpenOption.READ), "application/zip", "bilder.zip");
        } catch (IOException ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return file;
    }
}
