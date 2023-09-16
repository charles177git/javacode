package chapater5.practise2;

interface Production {
    public void setName(String name);
    public String getName();
    public double getPrice();
}
public class AnonymousProduction {
    public void shopping(Production production) {
        production.setName("CPU");
        System.out.println("I buy "+ production.getName() +", pay $"+ production.getPrice());
    }

    public static void main(String[] args) {
        int val = Integer.parseInt("123");
        String ab = String.valueOf(123);
        System.out.println(val + "," + ab);

        new AnonymousProduction().shopping(new Production() {
            String name;
            public void setName(String name) {
                this.name = name;
            }
            @Override
            public String getName() {
                return this.name;
            }

            @Override
            public double getPrice() {
                return 534.9;
            }
        });
    }

}
