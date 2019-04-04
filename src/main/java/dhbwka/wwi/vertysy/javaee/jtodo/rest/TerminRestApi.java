/*
 * Copyright © 2019 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertysy.javaee.jtodo.rest;

import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author maxwi
 */
@ApplicationPath("api")
public class TerminRestApi extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        // Hier für jede Webservice-Klasse eine Zeile hinzufügen
        resources.add(TerminResource.class);

        return resources;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
