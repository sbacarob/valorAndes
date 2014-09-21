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
public class ServletOperacionBursatil extends ServletTemplate
{

	//Se genera como operacionbursatil1.html
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
        return "Usuario";
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
        	
            imprimirDatos(respuesta,"");
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
    private void imprimirDatos( PrintWriter respuesta)
    {
    	respuesta.println("<header>");
        respuesta.println("    <h1>Ordenar Operación Bursátil</h1>");
        respuesta.println("</header>");
        respuesta.println("<div class=\"panel-central\" style=\"height:auto\">");
        respuesta.println("    <h2 class=\"form-title\">Detalles de Operación</h2>");
        respuesta.println("    <form class=\"form-central\" style='text-align:center' action=\"operacionbursatil2.html\">");
        respuesta.println("        <br><br>");
        respuesta.println("        <label for=\"sel-deloferente\" class=\"labformizq\" style='margin-left:35%'><b>Seleccione un oferente:</b></label><br><br>");
        respuesta.println("        <select style=\"width:40%; font-size:14pt; font-family:'Helvetica'\" id=\"sel-deloferente\">");
        respuesta.println("        </select><br><br>");
        respuesta.println("        <input type='submit' value='Enviar' style='width:40%; font-size:14pt; font-family:\"Helvetica\"'><br><br>");
        respuesta.println("    </form>");
        respuesta.println("</div>");
    }
    
    
    
    
    
    
    
    
    
}
