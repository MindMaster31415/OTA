package optimizedtravelassistant.hackventure.com.optimizedtravelassistant;

public class Attraction {

    private String name;
    private String address;
    private int thrill;
    private int active;
    private int explore;
    private int engage;
    private int party;
    private double latitude;
    private double longitude;
    private String description;

    public Attraction(String name, String address, int thrill, int active, int explore, int engage, int party, double latitude, double longitude, String description) {
        this.name = name;
        this.address = address;
        this.thrill = thrill;
        this.active = active;
        this.explore = explore;
        this.engage = engage;
        this.party = party;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public int getThrill() {
        return thrill;
    }

    public int getActive() {
        return active;
    }

    public int getExplore() {
        return explore;
    }

    public int getEngage() {
        return engage;
    }

    public int getParty() {
        return party;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
