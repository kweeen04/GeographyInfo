package model;

import java.util.Arrays;

public class ManageEastAsiaCountries {
    private EastAsiaCountries[] countries;

    public ManageEastAsiaCountries() {
        countries = new EastAsiaCountries[11];
    }

    public void addInfo(EastAsiaCountries country) throws Exception {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == null) {
                countries[i] = country;
                return;
            }
        } throw new Exception("Country information is full. Cannot add one.");
    }

    public EastAsiaCountries[] getRecentEnteredInfo() throws Exception {
        if (countries[0] == null) {
            throw new Exception("No country information available.");
        }
        return countries.clone();
    }

    public EastAsiaCountries[] searchByName(String name) throws Exception {
        EastAsiaCountries[] result = new EastAsiaCountries[countries.length];
        int count = 0;

        for(EastAsiaCountries country : countries) {
            if (country != null && country.getCountryName().equalsIgnoreCase(name)) {
                result[count] = country;
                count ++;
            }
        }

        if (count == 0) {
            throw new Exception("Not found the country with specified name!");
        }

        return Arrays.copyOf(result, count);
    }

    public EastAsiaCountries[] sortAscend() throws Exception {
        if (countries[0] == null) {
            throw new Exception("No country's information available.");
        }
    
        EastAsiaCountries[] filteredCountries = Arrays.stream(countries)
                .filter(country -> country != null)
                .toArray(EastAsiaCountries[]::new);
    
        if (filteredCountries.length == 0) {
            throw new Exception("No country's information available.");
        }
    
        Arrays.sort(filteredCountries, (a, b) -> a.getCountryName().compareToIgnoreCase(b.getCountryName()));
        return filteredCountries;
    }
}
