/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.jtodo.tasks.jpa;

/**
 * Statuswerte einer Aufgabe.
 */
public enum TaskStatus {
    OPEN, FINISHED, CANCELED;

    /**
     * Bezeichnung ermitteln
     *
     * @return Bezeichnung
     */
    public String getLabel() {
        switch (this) {
            case OPEN:
                return "Offen";
            case FINISHED:
                return "Erledigt";
            case CANCELED:
                return "Abgesagt";
            default:
                return this.toString();
        }
    }

}
