public class MultipleThreadExceptionTest {


    public static void main(String[] args) {

        System.out.println("11111111111");

        try {
            new Thread(()->{

                System.out.println("我是子线程");
                int a = 1 / 0;

            }).start();
        }catch (Exception e){
            System.out.println("3333333333");
        }



        System.out.println("222222222");

    }
}
