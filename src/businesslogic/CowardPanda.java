package businesslogic;

public class CowardPanda extends Panda{

    public CowardPanda(){
        DepthWriter.add();
        DepthWriter.print("CowardPanda CTOR");
        DepthWriter.reduce();
    }

    public void gmActivated(){
        DepthWriter.add();
        DepthWriter.print("CowardPanda.gmActivated()");
        scared();
        DepthWriter.reduce();
    }

    public void scared(){
        DepthWriter.add();
        DepthWriter.print("CowardPanda.scared()");
        DepthWriter.reduce();
    }
}
