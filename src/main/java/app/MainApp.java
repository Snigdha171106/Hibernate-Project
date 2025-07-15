package app;

import app.dao.RegionDAO;
import app.dao.CountryDAO;
import app.model.Region;
import app.model.Country;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        RegionDAO regionDAO = new RegionDAO();
        CountryDAO countryDAO = new CountryDAO();

        // REGION operations
        Region asia = new Region("Asia");
        regionDAO.insert(asia);

        List<Region> regions = regionDAO.getAll();
        System.out.println("Regions:");
        for (Region r : regions) {
            System.out.println(r);
        }

        // COUNTRY operations 
        Country ind = new Country("FR", "France", regions.get(0).getRegionId());
        countryDAO.insert(ind);

        List<Country> countries = countryDAO.getAll();
        System.out.println("\nCountries:");
        for (Country c : countries) {
            System.out.println(c);
        }
    }
}