package com.daos.Controller.Errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.daos.Exception.Excepcion;

public class ErrorInfo {

   @JsonProperty("status_code")
   private int statusCode;
   @JsonProperty("message")
   private String mensaje;
   @JsonProperty("uri")
   private String uriRequested;

   public ErrorInfo(Excepcion exception, String uriRequested) {
	   this.statusCode = exception.getStatusCode();
	   this.mensaje = exception.getMessage();
       this.uriRequested = uriRequested;
   }

   public ErrorInfo(int statusCode, String mensaje, String uriRequested) {
       this.mensaje = mensaje;
       this.statusCode = statusCode;
       this.uriRequested = uriRequested;
   }
   
   public int getStatusCode() {
       return statusCode;
   }
   
   public String getMensaje() {
       return mensaje;
   }

   public String getUriRequested() {
       return uriRequested;
   }

}