import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uniandes.videoAndes.fachada.VideoAndes;
import co.edu.uniandes.videoAndes.vos.VideosValue;

/**
 * clase plantilla, que sirve de base para el dearrollo de
 * los servlets. Extiende el template ServerTemplate,
 * para implementar la adición del header y del footer de 
 * la página web
 */
public class ServletVerExistencias extends ServletTemplate
{

	//ver-existencias.html
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
	 * serial
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Devuelve el título de la página para el Header
     * @param request Pedido del cliente
     * @return Título de la página para el Header
     */
    public String darTituloPagina( HttpServletRequest request )
    {
        return "Ordenar Operación Bursátil";
    }

    /**
     * Devuelve el nombre de la imagen para el título de la página en el Header
     * @param request Pedido del cliente
     * @return Nombre de la imagen para el título de la página en el Header
     */
    public String darImagenTitulo( HttpServletRequest request )
    {
    	
        return "";
    }

    /**
     * Escribe el contenido de la página
     * @param request Pedido del cliente
     * @param response Respuesta
     * @throws IOException Excepción de error al escribir la respuesta
     */
    public void escribirContenido( HttpServletRequest request, HttpServletResponse response ) throws IOException
    {
        
        // Saca el Printer
        PrintWriter respuesta = response.getWriter( );
        try
        {
        	
            imprimirDatos(request,respuesta);
        }
        catch( Exception e )
        {
            //
            // Imprime el mensaje de la excepción
            imprimirMensajeError( respuesta, "Error. ", "Excepción generada en la operación", e );
        }
    }

    /**
     * Imprime la tabla con los estudiantes
     * @param respuesta Respuesta al cliente
     * @param estudiantes Estudiantes a imprimir
     */
    private void imprimirDatos( HTTPServletRequest request, PrintWriter respuesta)
    {
    	String filtroValor= request.getParameter("filtrar-valor");
        String filtroTipoRent= request.getParameter("filtrar-tipo-rent");
        String filtroFechaExp= request.getParameter("filtrar-fecha-exp");
        String filtroIdInterm= request.getParameter("filtrar-id-interm");
        String filtroTipoV= request.getParameter("filtrar-tipov");
        String filtroIdOfer= request.getParameter("filtrar-id-oferente");
        String filtroIdInvers= request.getParameter("filtrar-id-invers");
        String filtroNegociando=("filtrar-negociando");
        String filtroNoNegociando=("filtrar-no-negociando");
    	respuesta.println("<header>");
        respuesta.println("    <h1>Órdenes</h1>");
        respuesta.println("</header>");
        respuesta.println("<div class=\"panel-central\">");
        respuesta.println("    <h2 class=\"form-title\">Mis Órdenes Pendientes</h2>");
        respuesta.println("    <table style=\"position:absolute;margin-left:25%;top:15%;\">");
        respuesta.println("        <th>ID Valor</th>");
        respuesta.println("        <th>ID Inversionista</th>");
        respuesta.println("        <th>ID Oferente</th>");
        respuesta.println("        <th>Tipo De Rentabilidad</th>");
        respuesta.println("        <th>Fecha de Expiración</th>");
        respuesta.println("        <th>Tipo de Valor</th>");
        respuesta.println("        <th>Negociando</th>");
        //for que recorre el resultado de la búsqueda
        respuesta.println("    </table>");
        respuesta.println("</div>");
    	
    }
    
