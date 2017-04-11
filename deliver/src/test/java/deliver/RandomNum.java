package deliver;

/**
*@CreateTime：2017年4月7日 下午2:44:13
*@Author sai.liu
*@ProjectPackage：deliver.RandomNum.java
*@Description：
*/

public class RandomNum {
	public static String getRequestNo(int id){
        String newNo = "" + id;
        int len = newNo.length();
        if(id<=9999999 && len<8){
        	for (int i = len; i < 7; i++) {
        		newNo = "0" + newNo;
            }
            return "1" + newNo;
        }else{
        	return newNo;
        }
    }
	public static void main(String[] args) {
		System.out.println(getRequestNo(3));
	}
}
