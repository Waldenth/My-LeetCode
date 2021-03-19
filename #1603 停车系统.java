class ParkingSystem {
    int[] carLocationNum;
    public ParkingSystem(int big, int medium, int small) {
        carLocationNum=new int[3];
        carLocationNum[0]=big;
        carLocationNum[1]=medium;
        carLocationNum[2]=small;
    }
    
    public boolean addCar(int carType) {
        if(carLocationNum[carType-1]!=0){
            carLocationNum[carType-1]--;
            return true;
        }else
            return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */