package org.java.oop.practice;

import java.util.ArrayList;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.json.*;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
//for templating json object
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.Template;

import org.jboss.logging.Logger;

import com.oracle.svm.core.annotate.Inject;

import io.quarkus.logging.Log;

@Path("/api")
public class Home {
    private static final Logger LOG = Logger.getLogger(Home.class);
    private Services matrixServices = new Services();
    private Integer rowNum;
    private Integer colsNum;
    private Integer minVal;
    private Integer maxVal;


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello() {
        return "<h2>This is a simple rest app with quarkus<h2>" +
        "<p>Which has following APIs:<p>" +
        "<ul>" +
        "<li>http://localhost:8080/api/</li>" +
        "<li>http://localhost:8080/api/genMatrix/{min}/{max}/{row}/{col}</li>" +
        "<li>http://localhost:8080/api/matrixDetail</li>" +
        "</ul>";
    }
    
    @Path("/genMatrix/{min}/{max}/{row}/{col}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String generateMatrix(
        @PathParam("min") Integer min,
        @PathParam("max") Integer max,
        @PathParam("row") Integer row,
        @PathParam("col") Integer col ) {
        //assign all values
        this.rowNum = row;
        this.colsNum = col;
        this.minVal = min;
        this.maxVal = max;
        //generate matrix
        matrixServices.genIntMatrix(this.minVal, this.maxVal,this.rowNum, this.colsNum);
        List<List<Integer>> theMatrix = matrixServices.getMatrix();
        Log.info(theMatrix);
        return "Matrix has been generated:\n" + 
        "And the matrix is:\n" +
        theMatrix;
    }


    @Path("/matrixDetail")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<MatrixInfo> matrixDetails(){
        List<MatrixInfo> matrixDet = new ArrayList<MatrixInfo>();
        if(matrixServices.getMatrix()!=null){
            List<List<Integer>> theMatrix = matrixServices.getMatrix();
            matrixDet.add(new MatrixInfo(this.rowNum, this.colsNum, this.minVal, this.maxVal,
            matrixServices.getMatrix(), matrixServices.getAllColumns(theMatrix)));
    
            return matrixDet;
        }
        //otherwise create a matrix first
        Log.info("Please create a matrix first");
        return matrixDet;

        
    }

    @Path("/oop")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    
    public String oopTests(){
        Rectangle rect1 = new Rectangle(4.0,5.0);
        Double area = rect1.calcArea(rect1.getLength(), rect1.getWidth());
        Double perimeter = rect1.calcPerimeter(rect1.getLength(), rect1.getWidth());
        Log.info(area);
        return "Rectangle\n Area:: " +area + "\n Perimter: " +perimeter;

        
    }
}