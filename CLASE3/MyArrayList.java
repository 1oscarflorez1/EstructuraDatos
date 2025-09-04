public class MyArrayList {
    private Object[] myArray;

    //metodo constructor
    public MyArrayList(int size){
        myArray = new Object[size];
    }

    public void add (Object object){
        if(size == myArray.length){
            increaseSize();
        }
        myArray[size]=object;
        size++;
    }

        if(!added){
            increaseSize();
            myArray
        }
    }
    //Metodo genera cadena del arreglo en formato val1 val2 val3
    public String toString(){
        String returnString = "";
        for (int i=0; i<myArray.length; i++){
            returnString += myArray[i] + ",";
        }
        return returnString;
    }
    private void increaseSize(){
        Object[] newArray = new Object[myArray.length*2];
        for (int i=0; i<myArray.length; i++){
            newArray[i] = myArray[i];
        }
        myArray=newArray;
    }
}