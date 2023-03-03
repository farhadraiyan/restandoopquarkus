package org.java.oop.practice;
import java.util.ArrayList;
import java.util.*;
import java.util.Random;

import org.jboss.logging.Logger;


public class Services implements IMatrix {
    private static final Logger LOG = Logger.getLogger(Services.class);
    private List<List<Integer>> matrix;
    

    // constructor to set the data type
    public Services(){ }
    //generate

    public List<List<Integer>> genIntMatrix(int minVal, int maxVal, int rowNum, int colNum){
        Random rn = new Random();
        //Row
        this.matrix = new ArrayList<List<Integer>>();
        for(int i=0; i<rowNum;i++){
            List<Integer> row = new ArrayList<Integer>();
            for(int j=0; j<colNum; j++){
                int randNum = rn.nextInt((maxVal-minVal)+1) + minVal;
                row.add(randNum);
            }
            this.matrix.add(row);
        }
        return this.matrix;
    }
    public Set<List<Integer>> getAllColumns(List<List<Integer>> theMatrix) {
        Set<List<Integer>> columns = new HashSet<>();
        int numRows = theMatrix.size();
        if (numRows == 0) {
            return columns;
        }
        int numCols = theMatrix.get(0).size();
        for (int j = 0; j < numCols; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> row = theMatrix.get(i);
                if (j < row.size()) {
                    col.add(row.get(j));
                }
            }
            columns.add(col);
        }
        return columns;
    }

    public List<List<Integer>> getMatrix(){
        return this.matrix;
    }
    
}

// Responsible to deal with all info of a matrix
class MatrixInfo {
    public Integer rowNums;
    public Integer colNums;
    public Integer maxVal;
    public Integer minVal;
    public List<List<Integer>> rows;
    public Set<List<Integer>> cols;
    public MatrixInfo(){

    }
    public MatrixInfo(
        Integer rn, Integer cn, Integer min, 
        Integer max, List<List<Integer>> rows, 
        Set<List<Integer>> cols){
        this.rowNums = rn;
        this.colNums = cn;
        this.maxVal = max;
        this.minVal = min;
        this.rows = rows;
        this.cols = cols;

    }
}
class Helper {

}

interface IMatrix {
    public List<List<Integer>> genIntMatrix(int minVal, int maxVal, int rowNum, int colNum);
    public Set<List<Integer>> getAllColumns(List<List<Integer>> theMatrix);

}
