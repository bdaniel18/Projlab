package businesslogic;

public class CowardPanda extends Panda{

    public CowardPanda(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("CowardPanda CTOR");
        DepthWriter.reduce();
    }

    public void gmActivated(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("CowardPanda.gmActivated()");
        scared();
        DepthWriter.reduce();
    }

    public void scared(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("CowardPanda.scared()");
        DepthWriter.reduce();
    }
}
