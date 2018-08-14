package controllers;

import models.clothes;

import play.api.templates.Html;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result main_page(Html content) {

        return ok(main_page.render(content));
    }

    public static Result index() {

        return main_page(home.render());
    }

    public static Result oder() {

        return main_page(oder.render());
    }

    public static Result promotion() {

        return main_page(promotion.render());
    }

    public static Result address() {

        return main_page(address.render());
    }

    public static Result product() {

        return main_page(product.render());
    }

    public static Result girl() {
        return main_page(girl.render());
    }

    public static Result home() {
        return main_page(home.render());
    }

    public static Result inputClothes() {
        return main_page(input.render());
    }


    public static Result PostClothes() {
        DynamicForm myForm = Form.form().bindFromRequest();
        //Collagen Collagen = new Collagen();
        String id, name, brand, category, number;
        double price;
        if (myForm.hasErrors()) {
            return main_page(input.render());
        } else {
            id = myForm.get("id");
            name = myForm.get("name");
            brand = myForm.get("brand");
            category = myForm.get("category");
            number = myForm.get("number");
            price = Double.parseDouble(myForm.get("price"));
            clothes Clothes = new clothes(id, name, brand, category, number, price);
            return main_page(showOutput.render(Clothes));
        }
    }

    public static Result dtp() {
        clothes p1 = new clothes("0001", "Boy", "SP","เสื้อ", "50", 190.00);
        clothes p2 = new clothes("0002", "Girl", "SP","เสื้อ", "60", 150.00);
        clothes p3 = new clothes("0003", "friends", "SP","เสื้อ", "50", 150.00);
        clothes p4 = new clothes("0004", "Boy", "SP","เสื้อ", "50", 190.00);
        clothes p5 = new clothes("0005", "Girl", "SP","เสื้อ", "60", 150.00);
        clothes p6 = new clothes("0006", "friends", "SP","เสื้อ", "50", 150.00);
        clothes o1 = new clothes("12345", "Boy", "SP","เสื้อ" ,"60", 190.00);
        return main_page(shop.render(p1, p2, p3, p4, p5, p6, o1));
    }

}
