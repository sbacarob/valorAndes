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
        	
            String accion = request.getParameter( "opc-compvend-of" );
            
            
            if(login!=null){
            	if(accion.equals("Comprar y vender mis productos"){
            		imprimirDatos(respuesta,"productos");	
            	}
            	else if(accion.equals("Comprar y vender de la bolsa"){
            		imprimirDatos(respuesta,"bolsa");
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
    private void imprimirDatos( PrintWriter respuesta, String accion)
    {
    	respuesta.println("<header>");
    	if(accion.equals("productos")
    	{
    		respuesta.println("	<h1>Comprar y vender de mis productos</h1>");
	        respuesta.println("</header>");
    		respuesta.println("<div class="panel-central" style="width:50%; height:auto">");
		respuesta.println("	<h2 class="form-title">Detalles de la operación:</h2>");
	        respuesta.println("	<br>");
	        respuesta.println("    	<form class=\"form-central\" style=\"text-align:center\" action=\"registrar-operacion-bursatil-of.html\">");
	        respuesta.println("            <br>");
	        respuesta.println("            <label for=\"accion-cv\" class=\"labformizq\" style=\"margin-left:45%\"><b>Acción:</b></label><br>");
	        respuesta.println("            <select style=\"width:40%; font-size:14pt; font-family:'Helvetica'\" name= \"opc-compvend-of\">");
	        respuesta.println("                <option value=\"Comprar\" id=\"Comprar\">Comprar</option>");
	        respuesta.println("                <option value=\"Vender\">Vender</option>");
	        respuesta.println("            </select><br><br>");
	        respuesta.println("            <input type=\"radio\" name=\"groupburs\" checked id=\"radcantidad\" class=\"input3\" value=\"cantidad\"><b>Por cantidad</b><input type=\"radio\" name=\"groupburs\" id=\"radprecio\" class=\"input3\" value=\"precio\"><b>Por precio</b> <br>");
	        respuesta.println("            <input type=\"text\" style=\"width:40%; font-size:14pt; font-family:'Helvetica'\" name=\"especif-of\" id=\"especif-of\" placeholder=\"Ingrese un valor\"><br><br>");
	        respuesta.println("            <label for=\"producto-opbur2\" class=\"labformizq\" style=\"margin-left:45%\"><b>Producto:</b></label><br>");
	        respuesta.println("            <select style=\"width:40%; font-size:14pt; font-family:'Helvetica'\" id='producto-opbur2' name='prod-selec-of'>");
	        respuesta.println("            </select><br><br>");
	        respuesta.println("            <input type='submit' value='Ordenar operación' style='width:40%; font-size:14pt; font-family:\"Helvetica\"'><br><br>");
	        respuesta.println("    	</form>");        
        	respuesta.println("</div>");
    	}
    	else if(accion.equals("bolsa")
    	{
    		respuesta.println("	<h1>Comprar y vender de la bolsa</h1>");
	        respuesta.println("</header>");
	        respuesta.println("<div class=\"panel-central\" style=\"height:auto\">");
	        respuesta.println("	<h2 class=\"form-title\">Detalles de Operación</h2>");
	        respuesta.println("	<form class=\"form-central\" style='text-align:center' action=\"operacionbursatil2.html\">");
	        respuesta.println("		<br><br>");
	        respuesta.println("		<label for=\"sel-deloferente\" class=\"labformizq\" style='margin-left:35%'><b>Seleccione un oferente:</b></label><br><br>");
	        respuesta.println("		<select style=\"width:40%; font-size:14pt; font-family:'Helvetica'\" id=\"sel-deloferente\" name=\"prod-selec-of>");
	        //for con las opciones que se van a ofrecer
	        respuesta.println("		</select><br><br>");
	        respuesta.println("		<input type='submit' value='Enviar' style='width:40%; font-size:14pt; font-family:\"Helvetica\"'><br><br>");
	        respuesta.println("	</form>");
	        respuesta.println("</div>");
    	}
    	
    	
    	
    }
    
    
    
    
