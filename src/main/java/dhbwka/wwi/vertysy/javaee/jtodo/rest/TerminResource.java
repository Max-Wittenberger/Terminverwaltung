
package dhbwka.wwi.vertysy.javaee.jtodo.rest;

import dhbwka.wwi.vertsys.javaee.jtodo.tasks.ejb.TaskBean;
import dhbwka.wwi.vertsys.javaee.jtodo.tasks.jpa.Termin;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author maxwi
 */

@Path("app/rest/Termin")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TerminResource {

    @EJB
    TaskBean taskBean;

// <editor-fold defaultstate="collapsed" desc="Zugriff auf die Collection">
    /**
     * GET /app/Termin/List/
     * Auslesen einer Liste von Musikstücken.
     * @return 
     */
    @GET
    public List<Termin> findTermine() {
        return this.taskBean.findAll();
    }

    /**
     * POST /api/Termin/
     * Speichern eines neuen Songs.
     * @param termin
     */
    @POST
    public Termin saveNewSong(@Valid Termin termin) {
        return this.taskBean.saveNew(termin);
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Zugriff auf einzelne Ressourcen">
    /**
     * GET /api/Songs/{id}/
     * Auslesen eines einzelnen Songs anhand seiner ID.
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public Termin getSong(@PathParam("id") long id) {
        return this.taskBean.findById(id);
    }

    /**
     * PUT /api/Songs/{id}/
     * Aktualisieren eines vorhandenen Songs.
     */
    @PUT
    @Path("{id}")
    public Termin updateSong(@PathParam("id") long id, @Valid Termin termin) {
        termin.setId(id);
        return this.taskBean.update(termin);
    }

    /**
     * DELETE /api/Songs/{id}/
     * Löschen eines vorhandenen Songs.
     * @param id
     * @return 
     */
    @DELETE
    @Path("{id}")
    public Termin deleteSong(@PathParam("id") long id) {
        Termin termin = this.taskBean.findById(id);

        if (termin != null) {
            this.taskBean.delete(termin);
        }

        return termin;
    }
// </editor-fold>
}