package shopping.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class PersistentProduct implements Serializable {

	private static final long serialVersionUID = 1529150892368175741L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 			 CascadeType.DETACH, CascadeType.REFRESH})
	@JsonIgnore
	@JoinColumn(name = "owner_id")
	private PersistentUser owner;

	@Column(name = "name")
	private String productName;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<PersistentCategory> productCategories;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = 
				{ CascadeType.PERSIST, CascadeType.MERGE, 
				  CascadeType.DETACH, CascadeType.REFRESH })
	@JoinTable(name = "users_favorites", 
			   joinColumns = @JoinColumn(name = "product_id"), 
			   inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<PersistentUser> favoriteUsers;

	@Column(name = "description")
	private String productDescription;

	@Column(name = "price")
	private double productPrice;
	
	@Column(name = "postDate")
	private Timestamp productPostDate;
	
	@Column(name = "isSold")
	private boolean productIsSold;
	
	@Column(name = "delivery")
	private String productDelivery;
	
	@Transient
	private MultipartFile productImage;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public PersistentUser getOwner() {
		return owner;
	}

	public void setOwner(PersistentUser owner) {
		this.owner = owner;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public List<PersistentCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(List<PersistentCategory> productCategories) {
		this.productCategories = productCategories;
	}
	
	public List<PersistentUser> getFavoriteUsers() {
		return favoriteUsers;
	}

	public void setFavoriteUsers(List<PersistentUser> favoriteUsers) {
		this.favoriteUsers = favoriteUsers;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Timestamp getProductPostDate() {
		return productPostDate;
	}

	public void setProductPostDate(Timestamp productPostDate) {
		this.productPostDate = productPostDate;
	}

	public boolean isProductIsSold() {
		return productIsSold;
	}

	public void setProductIsSold(boolean productIsSold) {
		this.productIsSold = productIsSold;
	}

	public String getProductDelivery() {
		return productDelivery;
	}

	public void setProductDelivery(String productDelivery) {
		this.productDelivery = productDelivery;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
}
