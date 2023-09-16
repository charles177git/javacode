package chapater5.innerclasspractise;

public class ComputerBoard implements Motherboard{
    @Override
    public void soundcard() {
        System.out.println("I have Jijia sound card");
    }

    @Override
    public void displaycard() {
        System.out.println("I am GPU display card");
    }

    @Override
    public void introduce() {
        //get interface default method.
        Motherboard.super.introduce();
        //get interface static method.
        System.out.println(Motherboard.getBoardName() + " board has " + Motherboard.getPorts() +" ports");
    }
    public static void main(String[] args) {
        ComputerBoard computerBoard = new ComputerBoard();
        computerBoard.displaycard();
        computerBoard.soundcard();
        computerBoard.introduce();

    }
}

