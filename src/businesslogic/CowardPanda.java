package businesslogic;

public class CowardPanda extends Panda{

    public CowardPanda(){
        System.out.println("CowardPanda CTOR");
    }

    public void gmActivated(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("CowardPanda.gmActivated()");
        DepthWriter.reduce();
    }

    public void scared(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("CowardPanda.scared()");
        DepthWriter.reduce();
    }
}
