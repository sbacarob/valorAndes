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
public class ServletOperacionBursatilOf extends ServletTemplate
{

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
        return "Resultado Órden";
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
        	
            imprimirDatos(respuesta,request);	
            
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
    private void imprimirDatos( PrintWriter respuesta, HttpServletRequest request)
    {
    
            String accion= request.getParameter("opc-compvend-of"); 
            String opcionCompra=request.getParameter("group-burs");
            String especificacion=request.getParameter("especif-of");
            String producto= request.getParameter("prod-selec-of");
    	
    }
}
