package pages.automationpractice.com;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPageAE extends CommonAPI {
    Logger LOG = LogManager.getLogger(ProductPageAE.class.getName());

    public ProductPageAE(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsBtn;

    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    WebElement firstViewProductBtn;

    @FindBy(tagName = "title")
    WebElement allProductsTitle;

    @FindBy(xpath = "//div[@class='col-sm-4']")
    WebElement allProductsList;

    @FindBy(xpath = "//div[@class='features_items']/h2")
    WebElement allProductsPageTitleElement;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    WebElement productNameElement;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(., 'Category')]")
    WebElement categoryElement;

    @FindBy(xpath = "//div[@class='product-information']/span/span")
    WebElement priceElement;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(., 'Availability')]")
    WebElement availabilityElement;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(., 'Condition')]")
    WebElement conditionElement;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(., 'Brand')]")
    WebElement brandElement;

    @FindBy(id = "search_product")
    WebElement searchField;

    @FindBy(id = "submit_search")
    WebElement searchSubmitBtn;

    @FindBy(xpath = "//div[@class='features_items']/div[@class='col-sm-4']")
    WebElement searchedProducts;

    @FindBy(xpath = "(//div[@class='single-products'])[1]")
    WebElement firstProductForHover;

    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    WebElement firstProductViewBtn;

    @FindBy(xpath = "//div[@class='overlay-content']/a[@data-product-id='1']")
    WebElement firstProductAddToCartBtn;

    @FindBy(xpath = "(//div[@class='single-products'])[1]")
    WebElement secondProductForHover;

    @FindBy(xpath = "//div[@class='overlay-content']/a[@data-product-id='1']")
    WebElement secondProductAddToCartBtn;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingBtb;

    @FindBy(xpath = "//div[@class='single-products']/div/p")
    List<WebElement> searchedProductsTitles;

    @FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr")
    List<WebElement> cartProducts;

    @FindBy(xpath = "//tbody/tr")
    List<WebElement> productRows;

    @FindBy(xpath = "//a[@href='#reviews']")
    WebElement reviewTitleElement;

    @FindBy(id = "name")
    WebElement reviewNameElement;

    @FindBy(id = "email")
    WebElement reviewEmailElement;

    @FindBy(id = "review")
    WebElement reviewCommentElement;

    @FindBy(id = "button-review")
    WebElement reviewSubmitBtn;

    @FindBy(xpath = "//div[@id='review-section']//span")
    WebElement reviewSuccessAlert;

    @FindBy(id = "quantity")
    WebElement productQuantityField;

    @FindBy(xpath = "(//div[@class='single-products'])")
    List<WebElement> allHoverableProducts;

    @FindBy(xpath = "(//div[@class='overlay-content']/a)")
    WebElement addCartBtn;

    //reusable steps
    public void clickOnFirstProductsLink(){
        clickOn(firstViewProductBtn);
        LOG.info("click on first product success");
    }

    public void clickOnProductsLink(){
        clickOn(productsBtn);
        LOG.info("click on products link success");
    }

    public String allProductsTitleText(){
        String allProductsTitle = getElementText(allProductsPageTitleElement);
        LOG.info("all products text visible: "+allProductsTitle);
        return allProductsTitle;
    }

    public String verifyReviewTitleText(){
        String reviewTitle = getElementText(reviewTitleElement);
        LOG.info("review form visible: "+reviewTitle);
        return reviewTitle;
    }

    public void verifyAllProductsList(){
        allProductsList.isDisplayed();
        LOG.info("all products visible success");
    }

    public void typeInSearchField(String searchText){
        type(searchField, searchText);
        LOG.info("type search text success");
    }

    public void clickOnSearchBtn(){
        clickOn(searchSubmitBtn);
        LOG.info("click on search button success");
    }

    public void verifySearchedProducts(){
        boolean searchedProduct = searchedProducts.isDisplayed();
        LOG.info("search products status: "+ searchedProduct);
    }

    public void verifySearchedProductsTitle(){
        String searchValue = searchField.getAttribute("value");

        for (WebElement searchedProductTitle : searchedProductsTitles) {
            String productName = searchedProductTitle.getText();

            if (productName.contains(searchValue)) {
                LOG.info("search product: "+ productName +" is match with search value");
            } else {
                LOG.info("search product: "+ productName +" is not match with search value");
            }
        }

        LOG.info("all searched products process success");
    }

    public void hoverOverFirstProduct(){
        hoverOver(firstProductForHover);
        LOG.info("hover over on first product success");
    }

    public void addToCartFirstProduct(){
        clickOn(firstProductAddToCartBtn);
        LOG.info("add to cart first product success");
    }

    public void hoverOverSecondProduct(){
        hoverOver(firstProductForHover);
        LOG.info("hover over on second product success");
    }

    public void addToCartSecondProduct(){
        hoverOver(firstProductAddToCartBtn);
        LOG.info("add to cart second product success");
    }

    public void clickOnAddToCartBtn(){
        clickOn(addToCartBtn);
        LOG.info("click on add to cart product in product detail success");
    }

    public void continueShoppingModalBtb(){
        clickOn(continueShoppingBtb);
        LOG.info("click on continue shopping button success");
    }

    public void verifyCartProducts(){
        for (WebElement cartProduct : cartProducts) {
            LOG.info("a product is on cart");
        }
        LOG.info("both products are added to Cart success");
    }

    public void verifyPriceQuantity(){
        for (WebElement row : productRows) {
            // Find elements within the current row
            WebElement priceElement = row.findElement(By.className("cart_price"));
            WebElement quantityElement = row.findElement(By.className("cart_quantity"));
            WebElement totalElement = row.findElement(By.className("cart_total_price"));

            // Get the text content of each element
            String priceText = priceElement.findElement(By.tagName("p")).getText();
            String quantityText = quantityElement.getText();
            String totalText = totalElement.getText();

            LOG.info("product price: "+ priceText);
            LOG.info("product quantity: "+ quantityText);
            LOG.info("product total price: "+ totalText);
        }
    }

    public void typeNameOnReviewForm(String name){
        type(reviewNameElement, name);
        LOG.info("type name on review form text success");
    }

    public void typeEmailOnReviewForm(String email){
        type(reviewEmailElement, email);
        LOG.info("type email on review form text success");
    }

    public void typeCommentOnReviewForm(String review){
        type(reviewCommentElement, review);
        LOG.info("type comment on review form text success");
    }

    public void typeProductQuantity(int quantity){
        type(productQuantityField, String.valueOf(quantity));
        LOG.info("type quantity on product detail success");
    }

    public void clickOnReviewSubmitBtn(){
        clickOn(reviewSubmitBtn);
        LOG.info("click on review submit button success");
    }

    public String verifyReviewSuccessAlert(){
        String reviewAlert = getElementText(reviewSuccessAlert);
        LOG.info("review success message visible: "+reviewAlert);
        return reviewAlert;
    }

    public String verifyProductDetailTitle(){
        String productDetailTitle = getCurrentTitle();
        LOG.info("product detail title is: "+productDetailTitle);
        return productDetailTitle;
    }

    public String getProductName(){
        String productName = getElementText(productNameElement);
        LOG.info("product name is: "+productName);
        return productName;
    }

    public String getProductCategory(){
        String productCategory = getElementText(categoryElement);
        LOG.info("product category is: "+productCategory);
        return productCategory;
    }

    public String getProductPrice(){
        String productPrice = getElementText(priceElement);
        LOG.info("product price is: "+productPrice);
        return productPrice;
    }

    public String getProductAvailability(){
        String productAvailability = getElementText(availabilityElement);
        LOG.info("product availability is: "+productAvailability);
        return productAvailability;
    }

    public String getProductCondition(){
        String productCondition = getElementText(conditionElement);
        LOG.info("product condition is: "+productCondition);
        return productCondition;
    }

    public String getProductBrand(){
        String productBrand = getElementText(brandElement);
        LOG.info("product brand is: "+productBrand);
        return productBrand;
    }

    public void addAllVisibleProductToCart(){
        List<WebElement> addCartButtons = driver.findElements(By.xpath("(//div[@class='overlay-content']/a)"));

        for (int i = 0; i < allHoverableProducts.size(); i++) {
            WebElement product = allHoverableProducts.get(i);

            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // hover over the product
            hoverOver(product);

            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // now click the "Add to Cart" button for the current product
            if (i < addCartButtons.size()) {
                WebElement addButton = addCartButtons.get(i);
                addButton.click();
            } else {
                System.out.println("No 'Add to Cart' button found for product " + (i + 1));
            }

            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            continueShoppingModalBtb();
        }
    }

}
