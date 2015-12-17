package kpfu;

/**
 * Created by etovladislav on 16.12.15.
 */


public class VladislavService {
    private Vlad vlad =  new Vlad();

    public String getVladName() {
        vlad.setName("kpfu.Vlad");
        return vlad.getName();
    }
}
