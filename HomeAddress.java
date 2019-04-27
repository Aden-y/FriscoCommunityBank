/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class HomeAddress extends CustomerAddress {
    private String communityName;
    public HomeAddress(int number, String street, String city, String state, int zip, String communityName) {
        super(number, street, city, state, zip);
        this.communityName = communityName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
    
}
