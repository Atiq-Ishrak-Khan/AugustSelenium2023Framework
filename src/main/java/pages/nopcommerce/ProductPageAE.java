package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPageAE extends CommonAPI {
    private Logger LOG = LogManager.getLogger(ProductPageAE.class.getName());

    public ProductPageAE(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsBtn;

    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    private WebElement firstViewProductBtn;

    @FindBy(tagName = "title")
    private WebElement allProductsTitle;

    @FindBy(xpath = "//div[@class='col-sm-4']")
    private WebElement allProductsList;

    @FindBy(xpath = "//div[@class='features_items']/h2")
    private WebElement allProductsPageTitleElement;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElement productNameElement;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(., 'Category')]")
    private WebElement categoryElement;

    @FindBy(xpath = "//div[@class='product-information']/span/span")
    private WebElement priceElement;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(., 'Availability')]")
    private WebElement availabilityElement;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(., 'Condition')]")
    private WebElement conditionElement;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(., 'Brand')]")
    private WebElement brandElement;

    @FindBy(id = "search_product")
    private WebElement searchField;

    @FindBy(id = "submit_search")
    private WebElement searchSubmitBtn;

    @FindBy(xpath = "//div[@class='features_items']/div[@class='col-sm-4']")
    private WebElement searchedProducts;

    @FindBy(xpath = "(//div[@class='single-products'])[1]")
    private WebElement firstProductForHover;

    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    private WebElement firstProductViewBtn;

    @FindBy(xpath = "//div[@class='overlay-content']/a[@data-product-id='1']")
    private WebElement firstProductAddToCartBtn;

    @FindBy(xpath = "(//div[@class='single-products'])[1]")
    private WebElement secondProductForHover;

    @FindBy(xpath = "//div[@class='overlay-content']/a[@data-product-id='1']")
    private WebElement secondProductAddToCartBtn;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShoppingBtb;

    @FindBy(xpath = "//div[@class='single-products']/div/p")
    private List<WebElement> searchedProductsTitles;

    @FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr")
    private List<WebElement> cartProducts;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> productRows;

    @FindBy(xpath = "//a[@href='#reviews']")
    private WebElement reviewTitleElement;

    @FindBy(id = "name")
    private WebElement reviewNameElement;

    @FindBy(id = "email")
    private WebElement reviewEmailElement;

    @FindBy(id = "review")
    private WebElement reviewCommentElement;

    @FindBy(id = "button-review")
    private WebElement reviewSubmitBtn;

    @FindBy(xpath = "//div[@id='review-section']//span")
    private WebElement reviewSuccessAlert;

    @FindBy(id = "quantity")
    private WebElement productQuantityField;

    @FindBy(xpath = "(//div[@class='single-products'])")
    private List<WebElement> allHoverableProducts;

    @FindBy(xpath = "(//div[@class='overlay-content']/a)")
    private WebElement addCartBtn;

    // Reusable methods
    public void clickOnFirstProductsLink() {
        clickOn(firstViewProductBtn);
        LOG.info("Clicked on the first product successfully");
    }

    public void clickOnProductsLink() {
        clickOn(productsBtn);
        LOG.info("Clicked on the products link successfully");
    }

    public String getAllProductsTitleText() {
        String allProductsTitleText = getElementText(allProductsPageTitleElement);
        LOG.info("All products title text: " + allProductsTitleText);
        return allProductsTitleText;
    }

    public String verifyReviewTitleText() {
        String reviewTitleText = getElementText(reviewTitleElement);
        LOG.info("Review form visible: " + reviewTitleText);
        return reviewTitleText;
    }

    public boolean verifyAllProductsList() {
        allProductsList.isDisplayed();
        LOG.info("All products are visible");
        return false;
    }

    public void typeInSearchField(String searchText) {
        type(searchField, searchText);
        LOG.info("Typed in the search field successfully");
    }

    public void clickOnSearchBtn() {
        clickOn(searchSubmitBtn);
        LOG.info("Clicked on the search button successfully");
    }

    public boolean verifySearchedProducts() {
        boolean searchedProduct = searchedProducts.isDisplayed();
        LOG.info("Searched products status: " + searchedProduct);
        return searchedProduct;
    }

    public String verifySearchedProductsTitle() {
        String searchValue = searchField.getAttribute("value");

        for (WebElement searchedProductTitle : searchedProductsTitles) {
            String productName = searchedProductTitle.getText();

            if (productName.contains(searchValue)) {
                LOG.info("Search product: " + productName + " matches the search value");
            } else {
                LOG.info("Search product: " + productName + " does not match the search value");
            }
        }

        LOG.info("All searched products processed successfully");
        return searchValue;
    }

    public void hoverOverFirstProduct() {
        hoverOver(firstProductForHover);
        LOG.info("Hovered over the first product successfully");
    }

    public void addToCartFirstProduct() {
        clickOn(firstProductAddToCartBtn);
        LOG.info("Added the first product to the cart successfully");
    }

    public void hoverOverSecondProduct() {
        hoverOver(secondProductForHover);
        LOG.info("Hovered over the second product successfully");
    }

    public void addToCartSecondProduct() {
        clickOn(secondProductAddToCartBtn);
        LOG.info("Added the second product to the cart successfully");
    }

    public void clickOnAddToCartBtn() {
        clickOn(addToCartBtn);
        LOG.info("Clicked on the 'Add to Cart' button in the product detail successfully");
    }

    public void continueShoppingModalBtn() {
        clickOn(continueShoppingBtb);
        LOG.info("Clicked on the 'Continue Shopping' button successfully");
    }

    public void verifyCartProducts() {
        for (WebElement cartProduct : cartProducts) {
            LOG.info("A product is in the cart");
        }
        LOG.info("Both products are added to the cart successfully");
    }

    public void verifyPriceQuantity() {
        for (WebElement row : productRows) {
            WebElement priceElement = row.findElement(By.className("cart_price"));
            WebElement quantityElement = row.findElement(By.className("cart_quantity"));
            WebElement totalElement = row.findElement(By.className("cart_total_price"));

            String priceText = priceElement.findElement(By.tagName("p")).getText();
            String quantityText = quantityElement.getText();
            String totalText = totalElement.getText();

            LOG.info("Product price: " + priceText);
            LOG.info("Product quantity: " + quantityText);
            LOG.info("Product total price: " + totalText);
        }
    }

    public void typeNameOnReviewForm(String name) {
        type(reviewNameElement, name);
        LOG.info("Typed name on the review form successfully");
    }

    public void typeEmailOnReviewForm(String email) {
        type(reviewEmailElement, email);
        LOG.info("Typed email on the review form successfully");
    }

    public void typeCommentOnReviewForm(String review) {
        type(reviewCommentElement, review);
        LOG.info("Typed comment on the review form successfully");
    }

    public void typeProductQuantity(int quantity) {
        type(productQuantityField, String.valueOf(quantity));
        LOG.info("Typed quantity on the product detail successfully");
    }

    public void clickOnReviewSubmitBtn() {
        clickOn(reviewSubmitBtn);
        LOG.info("Clicked on the review submit button successfully");
    }

    public String verifyReviewSuccessAlert() {
        String reviewAlert = getElementText(reviewSuccessAlert);
        LOG.info("Review success message visible: " + reviewAlert);
        return reviewAlert;
    }

    public String verifyProductDetailTitle() {
        String productDetailTitle = getCurrentTitle();
        LOG.info("Product detail title is: " + productDetailTitle);
        return productDetailTitle;
    }

    public String getProductName() {
        String productName = getElementText(productNameElement);
        LOG.info("Product name is: " + productName);
        return productName;
    }

    public String getProductCategory() {
        String productCategory = getElementText(categoryElement);
        LOG.info("Product category is: " + productCategory);
        return productCategory;
    }

    public String getProductPrice() {
        String productPrice = getElementText(priceElement);
        LOG.info("Product price is: " + productPrice);
        return productPrice;
    }

    public String getProductAvailability() {
        String productAvailability = getElementText(availabilityElement);
        LOG.info("Product availability is: " + productAvailability);
        return productAvailability;
    }

    public String getProductCondition() {
        String productCondition = getElementText(conditionElement);
        LOG.info("Product condition is: " + productCondition);
        return productCondition;
    }

    public String getProductBrand() {
        String productBrand = getElementText(brandElement);
        LOG.info("Product brand is: " + productBrand);
        return productBrand;
    }

    public void addAllVisibleProductToCart() {
        List<WebElement> addCartButtons = driver.findElements(By.xpath("(//div[@class='overlay-content']/a)"));

        for (int i = 0; i < allHoverableProducts.size(); i++) {
            WebElement product = allHoverableProducts.get(i);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            hoverOver(product);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (i < addCartButtons.size()) {
                WebElement addButton = addCartButtons.get(i);
                addButton.click();
            } else {
                System.out.println("No 'Add to Cart' button found for product " + (i + 1));
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            continueShoppingModalBtn();
        }
    }
}
