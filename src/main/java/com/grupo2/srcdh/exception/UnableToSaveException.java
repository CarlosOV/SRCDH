/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.exception;

import org.hibernate.HibernateException;
import static spark.Spark.halt;

/**
 *
 * @author carlos
 */
public class UnableToSaveException extends Exception {

    /**
     * Creates a new instance of <code>UnableToSaveException</code> without
     * detail message.
     */
    public UnableToSaveException() {
    }

    /**
     * Constructs an instance of <code>UnableToSaveException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnableToSaveException(String msg) {
        super(msg);
       
    }

    public UnableToSaveException(HibernateException e) {
        throw new UnsupportedOperationException("No se pudo persistir la data." + e); //To change body of generated methods, choose Tools | Templates.
    }
}
