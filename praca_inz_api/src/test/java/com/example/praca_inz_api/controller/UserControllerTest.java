package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.AllergiesConverter;
import com.example.praca_inz_api.converter.ContactConverter;
import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.dto.FoodListDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.model.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserControllerTest {

    private List<Food> prepareMockUserFood(){
        List<Food> myFood = new ArrayList<>();
        Food food = new Food();

        food.setType("Meal");
        myFood.add(food);

        food.setType("Meal");
        myFood.add(food);

        User user =  new User();
        user.set_id("620733937afc0720579330ae");
        user.setMyFood(myFood);

        return user.getMyFood();
    }

    private List<Contact> prepareMockUserContact(){
        List<Contact> myContact = new ArrayList<>();
        Contact contact = new Contact();

        contact.setType("Animal");
        myContact.add(contact);

        User user =  new User();
        user.set_id("620733937afc0720579330ae");
        user.setMyContact(myContact);

        return user.getMyContact();
    }

    private List<Allergies> prepareMockUserAllergies(){
        List<Allergies> myAllergies = new ArrayList<>();
        Allergies allergies = new Allergies();

        allergies.setAllergenId("6208299a5adf15753a523f34");
        allergies.setType("Food");
        myAllergies.add(allergies);

        User user =  new User();
        user.set_id("620733937afc0720579330ae");
        user.setMyAllergies(myAllergies);

        return user.getMyAllergies();
    }


    @Test
    public void shouldGetMyFoodList(){

        UserController userController = mock(UserController.class);

        given(userController.getMyFoodList("Meal", "620733937afc0720579330ae"))
        .willReturn(prepareMockUserFood()
                .stream()
                .map(FoodConverter::toFoodDTO)
                .collect(Collectors.toList()));

        List<FoodListDTO> myFoodList = userController
                .getMyFoodList("Meal", "620733937afc0720579330ae");

        Assert.assertThat(myFoodList, Matchers.hasSize(2));
    }

    @Test
    public void shouldGetMyContactList(){
        UserController userController = mock(UserController.class);

        when(userController.getMyContactList("Animal", "620733937afc0720579330ae"))
                .thenReturn(prepareMockUserContact()
                        .stream()
                        .map(ContactConverter::toContactDTO)
                        .collect(Collectors.toList()));

        Assert.assertThat(userController.getMyContactList("Animal", "620733937afc0720579330ae"),Matchers.hasSize(1) );
    }

    @Test
    public void shouldGetMyAllergiesList(){
        UserController userController = mock(UserController.class);

        when(userController.getMyAllergiesList("Food", "620733937afc0720579330ae"))
                .thenReturn(prepareMockUserAllergies()
                .stream()
                .map(AllergiesConverter::toListDTO)
                .collect(Collectors.toList()));

                Assert.assertThat(userController.getMyAllergiesList("Food", "620733937afc0720579330ae"), Matchers.hasSize(1));
    }

}