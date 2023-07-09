import java.util.*;
// import java.util.spi.CurrencyNameProvider;

import javax.xml.catalog.Catalog;

class categoryAndProducts{
    public static ArrayList<Category> category=new ArrayList<Category>();
    public static ArrayList<Product> products=new ArrayList<Product>();
    public static ArrayList<CustomerNormal> customerNormal=new ArrayList<>();
    public static ArrayList<CustomerElite> customerElite=new ArrayList<>();
    public static ArrayList<CustomerPrime> customerPrime=new ArrayList<>();
    public static ArrayList<Deal> giveAway=new ArrayList<>();
}
class Deal{
    private float productId1;
    private float productId2;
    private float normalPrice;
    private float primePrice;
    private float elitePrice;
    public void setproductId1(float productId1){this.productId1=productId1;}
    public void setproductId2(float productId2){this.productId2=productId2;}
    public void setnormalPrice(float normalPrice){this.normalPrice=normalPrice;}
    public void setprimePrice(float primePrice){this.primePrice=primePrice;}
    public void setelitePrice(float elitePrice){this.elitePrice=elitePrice;}
    public float getproductId1(){return this.productId1;}
    public float getproductId2(){return this.productId2;}
    public float getnormalPrice(){return this.normalPrice;}
    public float getprimePrice(){return this.primePrice;}
    public float getelitePrice(){return this.elitePrice;}
    public Deal(float productId1,float productId2,float normalPrice,float primePrice,float elitePrice){
        this.setelitePrice(elitePrice);
        this.setnormalPrice(normalPrice);
        this.setproductId1(productId1);
        this.setproductId2(productId2);
        this.setprimePrice(primePrice);
    }
        
}
class Category{
    private String name;
    private float category;
    public void setname(String name){
        this.name=name;
    }
    public String getname(){
        return this.name;
    }
    public void setcategory(float category){
        this.category=category;
    }
    public float getcategory(){
        return this.category;
    }
    public Category(String name,float category){
        this.setname(name);
        this.setcategory(category);

    }
}
class Product{
    public ArrayList<String> extraProperties=new ArrayList<>();
    public ArrayList<String> extraValues= new ArrayList<>();
    private String name;
    private int quantity;
    private float price_normal;
    private float price_prime;
    private float price_elite;
    private float id;
    private float categoryId;
    public void setquantity(int quantity){this.quantity=quantity;}
    public int getquantity(){return this.quantity;}
    public void setname(String name){this.name=name;}
    public void setprice_elite(float price_elite){this.price_elite=price_elite;}
    public void setprice_prime(float price_prime){this.price_prime=price_prime;}
    public void setprice_normal(float price_normal){this.price_normal=price_normal;}
    public void setid(float id){this.id=id;}
    public String getname(){return this.name;}
    public float getprice_normal(){return this.price_normal;}
    public float getid(){return this.id;}
    public float getprice_elite(){return this.price_elite;}
    public float getprice_prime(){return this.price_prime;}
    public void setcategoryId(float id){this.categoryId=id;}
    public float getcategoryId(){return this.categoryId;}
    public Product(String name,float id,float price_normal,float categoryId,int quantity){
        this.setname(name);
        this.setid(id);
        this.setprice_normal(price_normal);
        this.setprice_elite(price_normal);
        this.setprice_prime(price_normal);
        this.setcategoryId(categoryId);
        this.setquantity(quantity);
    }

}
class person{
    private String name;
    private String password;
    public void setname(String name){
        this.name=name;
    }
    public String getname(){
        return this.name;
    }
    public void setpassword(String password){
        this.password=password;
    }
    public String getpassword(){
        return this.password;
    }
}
class Admin extends person{
    Scanner sc= new Scanner(System.in);
    // static ArrayList customers=new ArrayList<Customer>();
    public void addCategory(){
        System.out.println("enter category ID ");
        float id=sc.nextFloat();
        boolean newCategory=true;
        for(int i=0;i<categoryAndProducts.category.size();i++){
            if(categoryAndProducts.category.get(i).getcategory()==(id)){
                System.out.println("category already exists ");
                newCategory=false;
            }
        }
        if(newCategory){
        System.out.println("enter the name of the category");
        String categoryName=sc.next();
        //instantiate the category and take a product also
        Category tempCategory=new Category(categoryName, id);
        categoryAndProducts.category.add(tempCategory);
        this.addProduct();}
        
    }
    public void deleteCategory(){
        System.out.println("enter the name of category you want to delete ");
        String name=sc.next();
        for(int i=0;i<categoryAndProducts.category.size();i++){
            if(categoryAndProducts.category.get(i).equals(name)){
                categoryAndProducts.category.remove(i);
                break;
            }
        }
    }
    public void addGiveAway(){
        System.out.println("enter the first product Id");
        float productId1=sc.nextFloat();
        System.out.println("enter the second product Id");
        float productId2=sc.nextFloat();
        System.out.println("enter the combined price(normal, prime, elite)");
        float totalPrice=0;
        for(int i=0;i<categoryAndProducts.products.size();i++){
            if(categoryAndProducts.products.get(i).getid()==productId1){
                totalPrice=totalPrice+categoryAndProducts.products.get(i).getprice_normal();
                break;
            }
        }
        for(int i=0;i<categoryAndProducts.products.size();i++){
            if(categoryAndProducts.products.get(i).getid()==productId2){
                totalPrice=totalPrice+categoryAndProducts.products.get(i).getprice_normal();
                break;
            }
        }
        
        float normalPrice=sc.nextFloat();
        if(normalPrice<totalPrice){
            float primePrice=sc.nextFloat();
            float elitePrice=sc.nextFloat();
            Deal tempDeal=new Deal(productId1, productId2, normalPrice, primePrice, elitePrice);
            categoryAndProducts.giveAway.add(tempDeal);
        }
       else{
        System.out.println("Prices are higher than usual");
       }
    }
    public void addProduct(){
        System.out.println("enter category id ");
        float categoryid=sc.nextFloat();
        System.out.println("enter product name ");
        String name=sc.next();
        System.out.println("enter product id ");
        float id=sc.nextFloat();
        System.out.println("enter the quantity ");
        int quantity=sc.nextInt();
        System.out.println("enter the priceNormal ");
        float price_normal=sc.nextFloat();
        Product tempProduct=new  Product(name,id,price_normal,categoryid,quantity);
        System.out.println("how many extra attributes you want to enter ");
        int extraAttributes=sc.nextInt();
        for(int i=0;i<extraAttributes;i++){
            System.out.println("enter the attribute ");
            String extraAttribute=sc.next();
            tempProduct.extraProperties.add(extraAttribute);
            System.out.println("enter the value ");
            String extraValue=sc.next();
            tempProduct.extraValues.add(extraValue);
        }
        categoryAndProducts.products.add(tempProduct);
    }
    public void deleteProduct(){
        System.out.println("enter the category name ");
        sc.next();
        System.out.println("enter the product id ");
        float productId=sc.nextFloat();
        for(int i=0;i<categoryAndProducts.products.size();i++){
            if(categoryAndProducts.products.get(i).getid()==productId){
                categoryAndProducts.products.remove(i);
                break;
            }
        }
    }
    public void setDiscountOnProduct(){
        System.out.println("enter the product ID");
        float productId=sc.nextFloat();
        System.out.println("enter the discount percentage for prime ");
        float discount_prime=sc.nextFloat();
        System.out.println("enter the discount percentage for elite ");
        float discount_elite=sc.nextFloat();
        System.out.println("enter the discount percentage for normal ");
        float discount_normal=sc.nextFloat();
        //apply the discounts
        for(int i=0;i<categoryAndProducts.products.size();i++){
            if(categoryAndProducts.products.get(i).getid()==productId){
                float price_normal=categoryAndProducts.products.get(i).getprice_normal()*(100-discount_normal)/100;
                float price_prime=categoryAndProducts.products.get(i).getprice_prime()*(100-discount_prime)/100;
                float price_elite=categoryAndProducts.products.get(i).getprice_elite()*(100-discount_elite)/100;
                categoryAndProducts.products.get(i).setprice_normal(price_normal);
                categoryAndProducts.products.get(i).setprice_prime(price_prime);
                categoryAndProducts.products.get(i).setprice_elite(price_elite);

            }
        }
    }
}
class CustomerNormal extends person{
    
    float amount=1000;
    public ArrayList<Deal> dealCart=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    // public LinkedList cart=new LinkedList<Product>();
    public ArrayList<Product> cart=new ArrayList<>();
    public ArrayList<Integer> quantityOfProduct=new ArrayList<>();
    private String status;
    public void setStatus(String status){
        this.status=status;
    }

    public String getStatus(){
        return this.status;
    }
    public CustomerNormal(String name,String password,float amount){
        this.setname(name);
        this.setpassword(password);
        this.setStatus("NORMAL");
        this.amount=amount;
    }
    // public void browseDeals(){
    //     System.out.println("the products are: ");
    //     for(int i=0;i<categoryAndProducts.products.size();i++){
    //         System.out.println("Product name: "+categoryAndProducts.products.get(i).getname());
    //         System.out.println("Price: "+categoryAndProducts.products.get(i).getprice_normal());
    //     }
    // }
    public void browseProducts(){
        System.out.println("These are the products we offer:");
        for(int i=0;i<categoryAndProducts.products.size();i++){
            System.out.println(i+") Product name: "+categoryAndProducts.products.get(i).getname());
            System.out.println("Price: "+categoryAndProducts.products.get(i).getprice_normal());
            System.out.println("Product id: "+categoryAndProducts.products.get(i).getid());
        }
    }
    public void checkAccountBalance(){
        System.out.println("Current account balance is Rupees "+amount);
    }
    public void browseDeals(){
        if(!categoryAndProducts.giveAway.isEmpty()){
            System.out.println("following are the deals available:");
            for(int i=0;i<categoryAndProducts.giveAway.size();i++){
                
                System.out.println(i+") Product Id "+categoryAndProducts.giveAway.get(i).getproductId1()+" + Product Id "+categoryAndProducts.giveAway.get(i).getproductId2()+"= Rs."+categoryAndProducts.giveAway.get(i).getnormalPrice());
            }
        }else{
            System.out.println("No deals available currently");
        }
    }
    public void addProductInDealToCart(){
        System.out.println("enter the deal number ");
        int dealNumber=sc.nextInt();
        dealCart.add(categoryAndProducts.giveAway.get(dealNumber));
        

    }
    // public void logIn(){
    //     System.out.println("enter name ");
    //             String name=sc.next();
    //             System.out.println("enter password ");
    //             String password=sc.next();
    //             int z;
    //             for(int i=0;i<Admin.customers.size();i++){
    //                 if(Admin.customers.get(i).name.equals(name) && Admin.customers.get(i).password.equals(password)){
    //                     z=i;
    //                     break;
    //                 }
    //             }
    //             // Customer currentCustomer=Admin.customers.get(z);
    //             System.out.println("Welcome "+currentCustomer.getname);
    //             System.out.println("\n1) browse products\n2) browse deals\n3) add a product to cart\n4) add products in deal to cart\n5) view coupons\n6) check account balance\n7) view cart\n8) empty cart\n9) checkout cart\n10) upgrade customer status\n11) Add amount to wallet\n12) back ");
    // }
    public void UpgradeStatus(){
        System.out.println("You can upgrade to \n1) Elite \n2) Prime\nChoose one option");
        int a=sc.nextInt();
        if(a==1){
            if(amount>=300){
                amount=amount-300;
                categoryAndProducts.customerNormal.remove(this);
                System.out.println("You are now an Elite member");
                CustomerElite tempCustomerElite=new CustomerElite(this.getname(),this.getpassword(),this.amount);
                categoryAndProducts.customerElite.add(tempCustomerElite);
                System.out.println("Please LogIn again to see the changes!!");
            }else{
                System.out.println("low balance");
            }
        }
        else if(a==2){
            if(amount>=200){
                amount=amount-200;
                categoryAndProducts.customerNormal.remove(this);
                System.out.println("You are now a Prime member");
                CustomerPrime tCustomerPrime=new CustomerPrime(this.getname(),this.getpassword(),this.amount);
                categoryAndProducts.customerPrime.add(tCustomerPrime);
                System.out.println("LogIn again to get all the benefits");
            }else{
                System.out.println("low balance");
            }
        }
    }
    public void addProductToCart(){
        System.out.println("enter product id ");
        float productId=sc.nextFloat();
        System.out.println("enter quantity ");
        int quantity=sc.nextInt();
        //do something to do with the quantity.
        for(int i=0;i<categoryAndProducts.products.size();i++){
            if(categoryAndProducts.products.get(i).getid()==productId){
                cart.add(categoryAndProducts.products.get(i));
                if(quantity<=categoryAndProducts.products.get(i).getquantity()){
                    quantityOfProduct.add(quantity);
                }else{
                    System.out.println("low product quantity");
                }
                break;
            }
        }
    }
    public void emptyCart(){
        cart.removeAll(cart);//check for this will work or not to empty the array.
        System.out.println("Cart successfully emptied");
    }
    public void viewCart(){
        for(int i=0;i<cart.size();i++){
            System.out.println(cart.get(i).getname()+" ,Price: "+cart.get(i).getprice_normal());
        }
        if(cart.isEmpty()){
            System.out.println("cart is empty");
        }
    }
    public void addAmountToWallet(){
        System.out.println("How much do amount you want to add ");
        float amountadd=sc.nextFloat();
        amount=amountadd+amount;
        System.out.println("Your wallet amount is "+amount);
    }
    public void checkoutDeal(){
        float totalAmount=0;
        for(int i=0;i<dealCart.size();i++){
            totalAmount=totalAmount+dealCart.get(i).getnormalPrice();

        }
        float netAmount=(float)((totalAmount*1.05)+100);
        if(amount>=netAmount){
            amount=amount-netAmount;
            System.out.println("Order successfully placed");
            System.out.println("total price: "+totalAmount+"+ delivery charge: 5% of "+totalAmount+"+100: "+netAmount);
            System.out.println("order will be delivered in 7-10 days");
        }else{
            System.out.println("low balance");
        }
        
    }
    public void viewCoupons(){
        System.out.println("You don't have any coupons ");
    }
    public void checkout(){
        float totalAmount=0; 
        // float netAmount=0;
        for(int i=0;i<this.cart.size();i++){
            totalAmount+=this.cart.get(i).getprice_normal()*this.quantityOfProduct.get(i);
           
        }

        float netAmount=(float)((1.05)*totalAmount+100);
        if(netAmount<=this.amount){
            amount=amount-totalAmount;
            System.out.println("Your order is placed successfully. Details: ");
            for(int i=0;i<this.cart.size();i++){
            System.out.println("Product name: "+this.cart.get(i).getname());
            System.out.println("Product id: "+this.cart.get(i).getid());
            for(int j=0;j<this.cart.get(i).extraProperties.size();j++){
                System.out.println(this.cart.get(i).extraProperties.get(j)+": "+this.cart.get(i).extraValues.get(j));
            } 
        } 
            System.out.println("Price: "+totalAmount);
            System.out.println("Discount: 0%");
            System.out.println("total cost= Price: "+totalAmount+"delivery charges=100 + 5% of "+totalAmount+"= "+netAmount);
            System.out.println("Delivery in 7-10 days");
            cart.removeAll(cart);
        }
        else{
            System.out.println("Insufficient wallet amount");
            cart.removeAll(cart);
        }
    }
}
class CustomerElite extends CustomerNormal{
    public ArrayList<Integer> coupons=new ArrayList<>();
    public CustomerElite(String name,String password,float amount){  
        super(name, password, amount);
    }
    @Override
    public void viewCoupons(){
        if(!coupons.isEmpty()){
            System.out.println("You have discounted coupons worth");
            for(int i=0;i<coupons.size();i++){
                System.out.println("discount: "+coupons.get(i)+"%");
            }
            
        }else{System.out.println("no discount coupons available yet");}
        
    }
    @Override
    public void checkout(){
        float totalAmount=0; 
        for(int i=0;i<this.cart.size();i++){
            totalAmount+=this.cart.get(i).getprice_normal()*this.quantityOfProduct.get(i);
        }
        if(!this.coupons.isEmpty()){
            System.out.println("coupons applied: "+coupons.get(coupons.size()-1)+"%");
            totalAmount=(totalAmount*((100-coupons.get(coupons.size()-1))));
            // System.out.println("total amount="+totalAmount);
            totalAmount=totalAmount/100;
            // System.out.println("total amount="+totalAmount);
        }
        float netAmount=(float)(0.9*totalAmount+100);
        if(netAmount<=this.amount){
            amount=amount-totalAmount;
            System.out.println("Your order is placed successfully. Details: ");
            for(int i=0;i<this.cart.size();i++){
            System.out.println("Product name: "+this.cart.get(i).getname());
            System.out.println("Product id: "+this.cart.get(i).getid());
            for(int j=0;j<this.cart.get(i).extraProperties.size();j++){
                System.out.println(this.cart.get(i).extraProperties.get(j)+": "+this.cart.get(i).extraValues.get(j));
            } 
        } 
            System.out.println("Price: "+totalAmount);
            System.out.println("Discount: 10% of "+totalAmount);
            System.out.println("total cost= Price: "+totalAmount+" delivery charges: 100 "+totalAmount+"= "+netAmount);
            System.out.println("Delivery in 2 days");
            if(netAmount>5000){
                System.out.println("Congrats!! You have got 4 coupons.");
                for(int i=0;i<4;i++){
                    int b = (int)(Math.random()*(15-5+1)+5);  
                    this.coupons.add(b);
                }
                Collections.sort(coupons);
            }
        }
        else{
            System.out.println("Insufficient wallet amount");
        }
    }
    @Override
    public void checkoutDeal(){
        float totalAmount=0;
        for(int i=0;i<dealCart.size();i++){
            totalAmount=totalAmount+dealCart.get(i).getnormalPrice();//++++++++++make geteliteprice

        }
        float netAmount=(float)((totalAmount)+100);
        if(amount>=netAmount){
            amount=amount-netAmount;
            System.out.println("Order successfully placed");
            System.out.println("total price: "+totalAmount+"+ delivery charge: 100 "+netAmount);
            System.out.println("order will be delivered in 2 days");
        }else{
            System.out.println("low balance");
        }
        
    }
    @Override
    public void viewCart(){
        for(int i=0;i<cart.size();i++){
            System.out.println(cart.get(i).getname()+" ,Price: "+cart.get(i).getprice_elite());
        }
    }

}
class CustomerPrime extends CustomerNormal{
    public ArrayList<Integer> coupons=new ArrayList<>();

    public CustomerPrime(String name, String password,float amount) {
        // super(name, password);
       super(name, password, amount);
        //TODO Auto-generated constructor stub
    }
    @Override
    public void viewCoupons(){
        if(!coupons.isEmpty()){
            System.out.println("You have discounted coupons worth");
            for(int i=0;i<coupons.size();i++){
                System.out.println("discount: "+coupons.get(i)+"%");
            }
            
        }
        else{System.out.println("no discount available yet");}
    }
    
    @Override
    public void viewCart(){
        for(int i=0;i<cart.size();i++){
            System.out.println(cart.get(i).getname()+" ,Price: "+cart.get(i).getprice_prime());
        }
    }
    @Override
    public void checkout(){
        float totalAmount=0; 
        // int quantityIndex=-1;
        for(int i=0;i<this.cart.size();i++){
            totalAmount+=this.cart.get(i).getprice_normal()*this.quantityOfProduct.get(i);   

        }
        if(!this.coupons.isEmpty()){
            System.out.println("coupons applied: "+coupons.get(coupons.size()-1)+"%");
            // totalAmount=(totalAmount*((100-coupons.get(coupons.size()-1))/100));
            totalAmount=(totalAmount*((100-coupons.get(coupons.size()-1))));
            // System.out.println("total amount="+totalAmount);
            totalAmount=totalAmount/100;
        }
        float netAmount=(float)((0.95*(1.02*totalAmount))+100);
        if(netAmount<=this.amount){
            // this.quantityOfProduct.set(quantityIndex, )
            amount=amount-totalAmount;
            System.out.println("Your order is placed successfully. Details: ");
            for(int i=0;i<this.cart.size();i++){
            System.out.println("Product name: "+this.cart.get(i).getname());
            System.out.println("Product id: "+this.cart.get(i).getid());
            for(int j=0;j<this.cart.get(i).extraProperties.size();j++){
                System.out.println(this.cart.get(i).extraProperties.get(j)+": "+this.cart.get(i).extraValues.get(j));
            } 
        } 
            System.out.println("Price: "+totalAmount);
            System.out.println("Discount: 5% of "+totalAmount);
            System.out.println("total cost= Price: "+totalAmount+"delivery charges=100 "+totalAmount+"= "+netAmount);
            System.out.println("Delivery in 3-6 days");
            if(netAmount>5000){
                System.out.println("Congrats!! You have got 2 coupons.");
                for(int i=0;i<2;i++){
                    int b = (int)(Math.random()*(15-5+1)+5);  
                    this.coupons.add(b);
                }
                Collections.sort(coupons);
            }
        }
        else{
            System.out.println("Insufficient wallet amount");
        }
    }
    @Override
    public void checkoutDeal(){
        float totalAmount=0;
        for(int i=0;i<dealCart.size();i++){
            totalAmount=totalAmount+dealCart.get(i).getnormalPrice();//+++++++++++++make getprimeprice

        }
        float netAmount=(float)((totalAmount*1.02)+100);
        if(amount>=netAmount){
            amount=amount-netAmount;
            System.out.println("Order successfully placed");
            System.out.println("total price: "+totalAmount+"+ delivery charge: 2% of "+totalAmount+"+100: "+netAmount);
            System.out.println("order will be delivered in 3-6 days");
        }else{
            System.out.println("low balance");
        }
        
    }
}
class flipzon1{
    public static void main(String args[]){
        Admin adminMain=new Admin();
        
        System.out.println("WELCOME TO FLIPZON");
        boolean innerflag1=false;
        while(!innerflag1){

        System.out.println(" 1) Enter as Admin \n 2) Explore the Product Catalog \n 3) Show Available Deals \n 4) Enter as Customer \n 5) Exit the Application");
        
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        if(a==1){
            //enter as admin
            System.out.println("Dear Admin,");
            System.out.println("Please enter your username ");
            String adminName=sc.next();
            sc.nextLine();//+++++++++++++add this line 
            // if(adminName.equals("Beff")||adminName.equals("Gill")){
            //     // System.out.println("Please enter your password ");
            //     // String password=sc.next();
            //     // sc.next();
            // }
            
            boolean innerflat2=false;
            while(!innerflat2){
            System.out.println(" Welcome "+adminName+"!!!!!\n Please choose any one of the following actions:\n 1) Add category\n 2 ) Delete category \n 3) Add Product\n  4) Delete Product\n 5) Set Discount on Product\n 6)  Add giveaway deal\n 7) Back");
            // int b=sc.nextInt();
            int b=sc.nextInt();
            if(b==1){
                //add category
                adminMain.addCategory();
            }
            else if(b==2){
                //delete category
                adminMain.deleteCategory();
            }
            else if(b==3){
                //add product
                // adminMain.
                adminMain.addProduct();
            }
            else if(b==4){
                //delete product
                adminMain.deleteProduct();
            }
            else if(b==5){
                //set discount on product
                adminMain.setDiscountOnProduct();
            }
            else if(b==6){
                //add giveaway deal
                adminMain.addGiveAway();
            }
            else if(b==7){
                //back
                innerflat2=true;
            }}

        }
        else if(a==2){
            //give the product catalog
            for(int i=0;i<categoryAndProducts.products.size();i++){
                System.out.println("Product name: "+categoryAndProducts.products.get(i).getname());
                System.out.println("Price: "+categoryAndProducts.products.get(i).getprice_normal());
                System.out.println(" ");
            }
        }
        else if(a==3){
            //set deals details
            if(!categoryAndProducts.giveAway.isEmpty()){
                for(int i=0;i<categoryAndProducts.giveAway.size();i++){
                    System.out.println("Product id 1: "+categoryAndProducts.giveAway.get(i).getproductId1()+" Product id 2: "+categoryAndProducts.giveAway.get(i).getproductId2()+" ,Price= "+categoryAndProducts.giveAway.get(i).getnormalPrice());
                }
            }else{
                System.out.println("dear user, there are no deals for now!!! Please check regularly for exiting offers");
            }
        }
        else if(a==4){
            //enter as customer
            boolean innerflag3=false;
            while(!innerflag3){
            System.out.println("1) Sign up\n2) Log in\n3) Back");
            int c=sc.nextInt();
            if(c==1){
                System.out.println("enter name ");
                String name=sc.next();
                System.out.println("enter password ");
                String password=sc.next();
                CustomerNormal tempcustomer=new CustomerNormal(name,password,1000);
                categoryAndProducts.customerNormal.add(tempcustomer);
                System.out.println("Customer successfully registered");
            }
            else if(c==2){
                // customerRep.logIn();
                System.out.println("enter name ");
                String name=sc.next();
                System.out.println("enter password ");
                String password=sc.next();
                int z;
                boolean primecustomer=true;
                boole13an eliteCustomer=true;

                
                // CustomerElite currentEliteCustomer=null;
                // CustomerPrime currentPrimeCustomer=null;
                String tempString="";
                for(int i=0;i<categoryAndProducts.customerNormal.size();i++){
                    if(categoryAndProducts.customerNormal.get(i).getname().equals(name)){
                    
                        CustomerNormal currentCustomer=categoryAndProducts.customerNormal.get(i);
                        

                        primecustomer=false;
                        eliteCustomer=false;
                        System.out.println("Welcome "+currentCustomer.getname());
                        boolean innerflag5=false;
                        while(!innerflag5){
                        System.out.println("\n1) browse products\n2) browse deals\n3) add a product to cart\n4) add products in deal to cart\n5) view coupons\n6) check account balance\n7) view cart\n8) empty cart\n9) checkout cart\n10) upgrade customer status\n11) Add amount to wallet\n12) checkout deal\n13) Back ");
                        int d=sc.nextInt();
                        if(d==1){
                            //browse products
                            currentCustomer.browseProducts();
                            
                        }
                        else if(d==2){
                            //browse deals
                            currentCustomer.browseDeals();
                        }
                        else if(d==3){
                            //browse add a product ot cart
                            currentCustomer.addProductToCart();
                        }
                        else if(d==4){
                            //add products in deal to cart
                            currentCustomer.addProductInDealToCart();
                        }
                        else if(d==5){
                            //view coupons
                            // currentCustomer
                            currentCustomer.viewCoupons();
                        }
                        else if(d==6){
                            //check account balance
                            currentCustomer.checkAccountBalance();
                        }
                        else if(d==7){
                            //view cart
                            currentCustomer.viewCart();
                        }
                        else if(d==8){
                            //empty cart
                            currentCustomer.emptyCart();
                        }
                        else if(d==9){
                            //checkout cart
                            currentCustomer.checkout();
                        }
                        else if(d==10){
                            //upgrade customer status
                            currentCustomer.UpgradeStatus();
                        }
                        else if(d==11){
                            //add amount to wallet
                            currentCustomer.addAmountToWallet();
                        }
                        else if(d==12){
                            //checkout deal
                            currentCustomer.checkoutDeal();
                        }
                        else if(d==13){
                            //back
                            innerflag5=true;
                            System.out.println("Bye custom name!!");
                        }}
        
        
                        break;
                    }
                }
                // currentCustomer=categoryAndProducts.customerNormal.get(z);
                if(eliteCustomer){
                    for(int i=0;i<categoryAndProducts.customerElite.size();i++){
                        if(categoryAndProducts.customerElite.get(i).getname().equals(name)){
                            CustomerElite currentCustomer=categoryAndProducts.customerElite.get(i);
                            // tempString="elite";
                            // z=i;
                            System.out.println("Welcome "+currentCustomer.getname());
                            boolean innerflag5=false;
                            while(!innerflag5){
                            System.out.println("\n1) browse products\n2) browse deals\n3) add a product to cart\n4) add products in deal to cart\n5) view coupons\n6) check account balance\n7) view cart\n8) empty cart\n9) checkout cart\n10) upgrade customer status\n11) Add amount to wallet\n12) checkout deal\n13) Back ");
                            int d=sc.nextInt();
                            if(d==1){
                                //browse products
                                currentCustomer.browseProducts();
                                
                            }
                            else if(d==2){
                                //browse deals
                                currentCustomer.browseDeals();
                            }
                            else if(d==3){
                                //browse add a product ot cart
                                currentCustomer.addProductToCart();
                            }
                            else if(d==4){
                                //add products in deal to cart
                                currentCustomer.addProductInDealToCart();
                            }
                            else if(d==5){
                                //view coupons
                                currentCustomer.viewCoupons();
                            }
                            else if(d==6){
                                //check account balance
                                currentCustomer.checkAccountBalance();
                            }
                            else if(d==7){
                                //view cart
                                currentCustomer.viewCart();
                            }
                            else if(d==8){
                                //empty cart
                                currentCustomer.emptyCart();
                            }
                            else if(d==9){
                                //checkout cart
                                currentCustomer.checkout();
                            }
                            else if(d==10){
                                //upgrade customer status
                                currentCustomer.UpgradeStatus();
                            }
                            else if(d==11){
                                //add amount to wallet
                                currentCustomer.addAmountToWallet();
                            }
                            else if(d==12){
                                //checkout deal
                                currentCustomer.checkoutDeal();
                            }
                            else if(d==13){
                                //back
                                innerflag5=true;
                                System.out.println("Bye custom name!!");
                            }}
            
            
                            primecustomer=false;
                            // eliteCustomer=false;
                    }
                }}
                if(primecustomer){
                    for(int i=0;i<categoryAndProducts.customerPrime.size();i++){
                        if(categoryAndProducts.customerPrime.get(i).getname().equals(name)){
                            CustomerPrime currentCustomer=categoryAndProducts.customerPrime.get(i);
                            // tempString=
                            // z=i;
                            // primecustomer=false;
                            System.out.println("Welcome "+currentCustomer.getname());
                            boolean innerflag5=false;
                            while(!innerflag5){
                            System.out.println("\n1) browse products\n2) browse deals\n3) add a product to cart\n4) add products in deal to cart\n5) view coupons\n6) check account balance\n7) view cart\n8) empty cart\n9) checkout cart\n10) upgrade customer status\n11) Add amount to wallet\n12) checkout deal\n13) Back ");
                            int d=sc.nextInt();
                            if(d==1){
                                //browse products
                                currentCustomer.browseProducts();
                                
                            }
                            else if(d==2){
                                //browse deals
                                currentCustomer.browseDeals();
                            }
                            else if(d==3){
                                //browse add a product ot cart
                                currentCustomer.addProductToCart();
                            }
                            else if(d==4){
                                //add products in deal to cart
                                currentCustomer.addProductInDealToCart();
                            }
                            else if(d==5){
                                //view coupons
                                currentCustomer.viewCoupons();
                            }
                            else if(d==6){
                                //check account balance
                                currentCustomer.checkAccountBalance();
                            }
                            else if(d==7){
                                //view cart
                                currentCustomer.viewCart();
                            }
                            else if(d==8){
                                //empty cart
                                currentCustomer.emptyCart();
                            }
                            else if(d==9){
                                //checkout cart
                                currentCustomer.checkout();
                            }
                            else if(d==10){
                                //upgrade customer status
                                currentCustomer.UpgradeStatus();
                            }
                            else if(d==11){
                                //add amount to wallet
                                currentCustomer.addAmountToWallet();
                            }
                            else if(d==12){
                                //checkout deal
                                currentCustomer.checkoutDeal();
                            }
                            else if(d==13){
                                //back
                                innerflag5=true;
                                System.out.println("Bye custom name!!");
                            }}
            
            
                            eliteCustomer=false;
                            // categoryAndProducts.customerNormal.get(1).
                    }
                }
                }
                
                // currentCustomer=categoryAndProducts.customer.get(z);

                // Customer currentCustomer=Admin.customers.get(z);
                



            }
            else if(c==3){
                innerflag3=true;
            }}

        }
        else if(a==5){
            //exit the application
            innerflag1=true;
        }}
    }
}



