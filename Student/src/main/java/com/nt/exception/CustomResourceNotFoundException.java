package com.nt.exception;

import java.util.UUID;

public class CustomResourceNotFoundException extends RuntimeException {


  public CustomResourceNotFoundException(String message){

      super(message);
  }

}
