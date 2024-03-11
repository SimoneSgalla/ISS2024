package unibo.naiveactors24;

public interface IActor24 {
    public String getName();
    public String getContextName();
    //public void activate();
    public void activateAndStart();
    public void addObserver(String s);
    public void updateResources(String s);
}
