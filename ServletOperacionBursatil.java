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
public class ServletPlantilla extends ServletTemplate
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
        	
            String login = request.getParameter( "loginlogin" );
            String contrasenia = request.getParameter( "contrasenialogin" );
            
            if(login!=null){
            	if(login.equals("intermediario" && contrasenia!=null){
            		imprimirDatos(respuesta,"Intermediario");	
            	}
            	else if(login.equals("inversionista" && conrasenia!=null){
            		imprimirDatos(respuesta,"Inversionista");
            	}
            	else if(login.equals("oferente" && contrasenia!=null){
            		imprimirDatos(respuesta,"Oferente");
            	}
            	else{
            		imprimirMensajeError(respuesta,"Los datos de ingreso no son correctos");
            	}
            }
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
    private void imprimirDatos( PrintWriter respuesta, String tipoUsuario)
    {
    	respuesta.println("<header>");
    	
    	if(tipoUsuario.equals("Intermediario"){
	        respuesta.println("    <h1>Intermediario X</h1>");
    	}
    	else if(tipoUsuario.equals("Inversionista"){
  		respuesta.println("    <h1>Inversionista X</h1>");
    	}
    	else{
  		respuesta.println("    <h1>Oferente X</h1>");
    	}
	
    	respuesta.println("</header>");
    	respuesta.println("<div class=\"sidebar\">");
	    respuesta.println("    <br>");
      respuesta.println("    <br>");
      if(tipoUsuario.equals("Intermediario"){
	        respuesta.println("    <a href=\"operacionesordenadas.html\" class=\"linksidebar\"><b>Ver Operaciones<br> Bursátiles Ordenadas</b></a>");
    	}
	    else{
		    respuesta.println("	<a href=\"operacionbursatil1.html\" class=\"linksidebar\"><b>Ordenar Operación<br> Bursátil</b></a>");
    		respuesta.println("	<br><br>");
    		respuesta.println("    <a href="" class=\"linksidebar\"><b>Consultar Existencias<br> de Valores</b></a>");
	    }
      respuesta.println("</div>");
      respuesta.println("</body>");
    }
    
    
    
    
    
    
    
    
    
}
