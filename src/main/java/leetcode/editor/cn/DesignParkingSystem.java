package leetcode.editor.cn;

//1603 设计停车系统
/* ["ParkingSystem","addCar","addCar","addCar","addCar"],[[1,1,0],[1],[2],[3],[1]] */
public class DesignParkingSystem {

    //leetcode submit region begin(Prohibit modification and deletion)
    class ParkingSystem {
        private int[] data;

        public ParkingSystem(int big, int medium, int small) {
            data = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            if (carType > 3 || carType < 1) return false;
            if (data[carType - 1] > 0) {
                data[carType - 1]--;
                return true;
            }
            return false;
        }
    }

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
//leetcode submit region end(Prohibit modification and deletion)

}