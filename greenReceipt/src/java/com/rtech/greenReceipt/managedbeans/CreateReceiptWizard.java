/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rtech.greenReceipt.managedbeans;

import com.rtech.greenReceipt.model.Receipts;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.imageio.stream.FileImageOutputStream;
import org.primefaces.event.CaptureEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author varunFG
 */
@Named(value = "createReceiptWizard")
@ViewScoped
public class CreateReceiptWizard implements Serializable{

    private Receipts receipt = new Receipts();
    private String filename;

    public Receipts getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipts receipt) {
        this.receipt = receipt;
    }
    public CreateReceiptWizard() {
    }
    
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public String onFlowProcess(FlowEvent event) {
  
            return event.getNewStep();
    }
     
    private String getRandomImageName() {
        int i = (int) (Math.random() * 10000000);
         
        return String.valueOf(i);
    }
 
    public String getFilename() {
        return filename;
    }
     
    public void oncapture(CaptureEvent captureEvent) {
        filename = getRandomImageName();
        byte[] data = captureEvent.getData();
 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String newFileName = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" +
                                    File.separator + "images" + File.separator + "photocam" + File.separator + filename + ".jpeg";
         
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        }
        catch(IOException e) {
            throw new FacesException("Error in writing captured image.", e);
        }
    }
}
