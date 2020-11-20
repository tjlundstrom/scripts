import java.sql.Timestamp;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

import org.joda.time.DateTime;

import com.kuebix.beans.salesforce.FieldMetadata;
import com.kuebix.beans.salesforce.FieldMetadata.FieldType;
import com.kuebix.beans.salesforce.Id;
import com.kuebix.beans.salesforce.NamedSObjectPOJO;
import com.kuebix.beans.TypeMapper;

public class InvoiceStatusEdiPOJO extends NamedSObjectPOJO {
	private static Map<String,FieldMetadata> columnMap = new HashMap<String,FieldMetadata> ();

	//
	// Static code blocks are thread safe:
	//   http://docs.oracle.com/javase/specs/jls/se7/html/jls-12.html#jls-12.4.2
	//
	static {
		columnMap.putAll(NamedSObjectPOJO.getColumnMap());

		columnMap.put ("rateQuoteId", new FieldMetadata ("Rate Quote", "Rate_Quote__c", FieldType.TEXT, 18, 0, 0, false));
		columnMap.put ("accessorialCharge", new FieldMetadata ("Accessorial Charge", "Accessorial_Charge__c", FieldType.CURRENCIES, 0, 10, 2, false));
		columnMap.put ("accountPayableApId", new FieldMetadata ("Account Payable (AP)", "Account_Payable_AP__c", FieldType.TEXT, 18, 0, 0, false));
		columnMap.put ("actualDeliveryDate", new FieldMetadata ("Actual Delivery Date", "Actual_Delivery_Date__c", FieldType.TEXT, 20, 0, 0, false));
		columnMap.put ("actualInvoiceDate", new FieldMetadata ("Actual Invoice Date", "Actual_Invoice_Date__c", FieldType.TEXT, 20, 0, 0, false));
		columnMap.put ("actualPickupDate", new FieldMetadata ("Actual Pickup Date", "Actual_Pickup_Date__c", FieldType.TEXT, 20, 0, 0, false));
		columnMap.put ("bolNumber", new FieldMetadata ("Potential Shipment", "BOL_Number__c", FieldType.TEXT, 32, 0, 0, false));
		columnMap.put ("billToAddress", new FieldMetadata ("Bill To Address", "Bill_To_Address__c", FieldType.TEXT, 255, 0, 0, false));
		columnMap.put ("billToCity", new FieldMetadata ("Bill To City", "Bill_To_City__c", FieldType.TEXT, 50, 0, 0, false));
		columnMap.put ("billToClientName", new FieldMetadata ("Bill To Client Name", "Bill_To_Client_Name__c", FieldType.TEXT, 32, 0, 0, false));
		columnMap.put ("billToContact", new FieldMetadata ("Bill To Contact", "Bill_To_Contact__c", FieldType.TEXT, 255, 0, 0, false));
		columnMap.put ("billToPhone", new FieldMetadata ("Bill To Phone", "Bill_To_Phone__c", FieldType.TEXT, 40, 0, 0, false));
		columnMap.put ("billToPostalCode", new FieldMetadata ("Bill To Postal Code", "Bill_To_Postal_Code__c", FieldType.TEXT, 10, 0, 0, false));
		columnMap.put ("billToStateProvince", new FieldMetadata ("Bill To State/Province", "Bill_To_State_Province__c", FieldType.TEXT, 50, 0, 0, false));
		columnMap.put ("ciJobNumber", new FieldMetadata ("CI Job Number", "CI_Job_Number__c", FieldType.TEXT, 32, 0, 0, false));
		columnMap.put ("carrierInvoiceNumber", new FieldMetadata ("Carrier Invoice Number", "Carrier_Invoice_Number__c", FieldType.TEXT, 32, 0, 0, false));
		columnMap.put ("carrierScac", new FieldMetadata ("Carrier SCAC", "Carrier_SCAC__c", FieldType.TEXT, 10, 0, 0, false));
		columnMap.put ("carrier", new FieldMetadata ("Carrier", "Carrier__c", FieldType.TEXT, 32, 0, 0, false));
		columnMap.put ("caseClosed", new FieldMetadata ("Case Closed", "Case_Closed__c", FieldType.TEXT, 1300, 0, 0, true));
		columnMap.put ("caseId", new FieldMetadata ("Case", "Case__c", FieldType.TEXT, 18, 0, 0, false));
		columnMap.put ("clientBol", new FieldMetadata ("Client BOL #", "Client_BOL__c", FieldType.TEXT, 100, 0, 0, false));
		columnMap.put ("client", new FieldMetadata ("Client", "Client__c", FieldType.TEXT, 32, 0, 0, false));
		columnMap.put ("description", new FieldMetadata ("Description", "Description__c", FieldType.TEXT, 255, 0, 0, false));
		columnMap.put ("destinationAddress", new FieldMetadata ("Destination Address", "Destination_Address__c", FieldType.TEXT, 255, 0, 0, false));
		columnMap.put ("destinationCity", new FieldMetadata ("Destination City", "Destination_City__c", FieldType.TEXT, 50, 0, 0, false));
		columnMap.put ("destinationCompany", new FieldMetadata ("Destination Company", "Destination_Company__c", FieldType.TEXT, 50, 0, 0, false));
		columnMap.put ("destinationContact", new FieldMetadata ("Destination Contact", "Destination_Contact__c", FieldType.TEXT, 255, 0, 0, false));
		columnMap.put ("destinationPhone", new FieldMetadata ("Destination Phone", "Destination_Phone__c", FieldType.TEXT, 40, 0, 0, false));
		columnMap.put ("destinationPostalCode", new FieldMetadata ("Destination Postal Code", "Destination_Postal_Code__c", FieldType.TEXT, 10, 0, 0, false));
		columnMap.put ("destinationStateProvince", new FieldMetadata ("Destination State/Province", "Destination_State_Province__c", FieldType.TEXT, 50, 0, 0, false));
		columnMap.put ("differenceRqMinusEdi", new FieldMetadata ("Difference (RQ minus EDI)", "Difference_RQ_minus_EDI__c", FieldType.CURRENCIES, 0, 10, 2, false));
		columnMap.put ("fuelSurcharge", new FieldMetadata ("Fuel Surcharge", "Fuel_Surcharge__c", FieldType.CURRENCIES, 0, 10, 2, false));
		columnMap.put ("internalBookedAccessorialCharge", new FieldMetadata ("Internal Booked Accessorial Charge", "Internal_Booked_Accessorial_Charge__c", FieldType.CURRENCIES, 0, 18, 2, true));
		columnMap.put ("internalBookedFscCharge", new FieldMetadata ("Internal Booked FSC Charge", "Internal_Booked_FSC_Charge__c", FieldType.CURRENCIES, 0, 18, 2, true));
		columnMap.put ("internalBookedLinehaul", new FieldMetadata ("Internal Booked Linehaul", "Internal_Booked_Linehaul__c", FieldType.CURRENCIES, 0, 18, 2, true));
		columnMap.put ("internalBookedSurcharge", new FieldMetadata ("Internal Booked Surcharge", "Internal_Booked_Surcharge__c", FieldType.CURRENCIES, 0, 18, 2, true));
		columnMap.put ("internalBookedTotalCharge", new FieldMetadata ("Internal Booked Total Charge", "Internal_Booked_Total_Charge__c", FieldType.CURRENCIES, 0, 18, 2, true));
		columnMap.put ("internalShipmentAccessorial", new FieldMetadata ("Internal Shipment Accessorial", "Internal_Shipment_Accessorial__c", FieldType.TEXT, 1300, 0, 0, true));
		columnMap.put ("invalidated", new FieldMetadata ("Invalidated", "Invalidated__c", FieldType.BOOLEANS, 0, 0, 0, false));
		columnMap.put ("invoiceLineItems", new FieldMetadata ("Invoice Line Items", "Invoice_Line_Items__c", FieldType.TEXT, 32768, 0, 0, false));
		columnMap.put ("invoiceStatusId", new FieldMetadata ("Invoice Status Id", "Invoice_Status_Id__c", FieldType.TEXT, 100, 0, 0, false));
		columnMap.put ("invoiceId", new FieldMetadata ("Invoice", "Invoice__c", FieldType.TEXT, 18, 0, 0, false));
		columnMap.put ("linehaulCharge", new FieldMetadata ("Linehaul Charge", "Linehaul_Charge__c", FieldType.CURRENCIES, 0, 10, 2, false));
		columnMap.put ("netAmountDue", new FieldMetadata ("Net Amount Due", "Net_Amount_Due__c", FieldType.CURRENCIES, 0, 10, 2, false));
		columnMap.put ("notes", new FieldMetadata ("Notes", "Notes__c", FieldType.TEXT, 32768, 0, 0, false));
		columnMap.put ("originAddress", new FieldMetadata ("Origin Address", "Origin_Address__c", FieldType.TEXT, 255, 0, 0, false));
		columnMap.put ("originCity", new FieldMetadata ("Origin City", "Origin_City__c", FieldType.TEXT, 50, 0, 0, false));
		columnMap.put ("originCompany", new FieldMetadata ("Origin Company", "Origin_Company__c", FieldType.TEXT, 100, 0, 0, false));
		columnMap.put ("originContact", new FieldMetadata ("Origin Contact", "Origin_Contact__c", FieldType.TEXT, 255, 0, 0, false));
		columnMap.put ("originPhone", new FieldMetadata ("Origin Phone", "Origin_Phone__c", FieldType.TEXT, 40, 0, 0, false));
		columnMap.put ("originPostalCode", new FieldMetadata ("Origin Postal Code", "Origin_Postal_Code__c", FieldType.TEXT, 10, 0, 0, false));
		columnMap.put ("originStateProvince", new FieldMetadata ("Origin State/Province", "Origin_State_Province__c", FieldType.TEXT, 50, 0, 0, false));
		columnMap.put ("poNumber", new FieldMetadata ("PO Number", "PO_Number__c", FieldType.TEXT, 200, 0, 0, false));
		columnMap.put ("pro", new FieldMetadata ("PRO#", "PRO__c", FieldType.TEXT, 32, 0, 0, false));
		columnMap.put ("parentApFound", new FieldMetadata ("Parent AP found", "Parent_AP_found__c", FieldType.BOOLEANS, 0, 0, 0, false));
		columnMap.put ("parentCaseFound", new FieldMetadata ("Parent Case found", "Parent_Case_found__c", FieldType.BOOLEANS, 0, 0, 0, false));
		columnMap.put ("parentInvoiceFound", new FieldMetadata ("Parent Invoice found", "Parent_Invoice_found__c", FieldType.BOOLEANS, 0, 0, 0, false));
		columnMap.put ("parentRateQuoteFound", new FieldMetadata ("Parent Rate Quote Found", "Parent_Rate_Quote_Found__c", FieldType.BOOLEANS, 0, 0, 0, false));
		columnMap.put ("parentShipmentFound", new FieldMetadata ("Parent Shipment Found", "Parent_Shipment_Found__c", FieldType.BOOLEANS, 0, 0, 0, false));
		columnMap.put ("parentSupportRateQuoteFound", new FieldMetadata ("Parent Support Rate Quote Found", "Parent_Support_Rate_Quote_Found__c", FieldType.BOOLEANS, 0, 0, 0, false));
		columnMap.put ("potentialRateQuote", new FieldMetadata ("Potential Rate Quote", "Potential_Rate_Quote__c", FieldType.TEXT, 32, 0, 0, false));
		columnMap.put ("shipmentAccessorialId", new FieldMetadata ("Shipment Accessorial", "Shipment_Accessorial__c", FieldType.TEXT, 18, 0, 0, false));
		columnMap.put ("shipmentId", new FieldMetadata ("Shipment", "Shipment__c", FieldType.TEXT, 18, 0, 0, false));
		columnMap.put ("status", new FieldMetadata ("Status", "Status__c", FieldType.TEXT, 255, 0, 0, false));
		columnMap.put ("supportRateQuoteId", new FieldMetadata ("Support Rate Quote", "Support_Rate_Quote__c", FieldType.TEXT, 18, 0, 0, false));
		columnMap.put ("surcharge", new FieldMetadata ("Surcharge", "Surcharge__c", FieldType.CURRENCIES, 0, 10, 2, false));
		columnMap.put ("validationDetails", new FieldMetadata ("Validation Details", "Validation_Details__c", FieldType.TEXT, 32768, 0, 0, false));
		columnMap.put ("weight", new FieldMetadata ("Weight", "Weight__c", FieldType.TEXT, 10, 0, 0, false));
		columnMap.put ("exceptionId", new FieldMetadata ("Exception", "Exception__c", FieldType.TEXT, 18, 0, 0, false));
		columnMap.put ("accessorialList", new FieldMetadata ("Accessorial List", "Accessorial_List__c", FieldType.TEXT, 32768, 0, 0, false));
		columnMap.put ("apiReviewed", new FieldMetadata ("API Reviewed", "API_Reviewed__c", FieldType.BOOLEANS, 0, 0, 0, false));
		columnMap.put ("hidden", new FieldMetadata ("Hidden", "Hidden__c", FieldType.BOOLEANS, 0, 0, 0, false));
	}

	//
	// Label: Rate Quote
	// References: RateQuote
	//
	private	Id	rateQuoteId;

	//
	// Label: Accessorial Charge
	// Precision: 10, Scale: 2
	//
	private	BigDecimal	accessorialCharge;

	//
	// Label: Account Payable (AP)
	// References: AccountsPayable
	//
	private	Id	accountPayableApId;

	//
	// Label: Actual Delivery Date
	// Max Length: 20
	//
	private	String	actualDeliveryDate;

	//
	// Label: Actual Invoice Date
	// Max Length: 20
	//
	private	String	actualInvoiceDate;

	//
	// Label: Actual Pickup Date
	// Max Length: 20
	//
	private	String	actualPickupDate;

	//
	// Label: Potential Shipment
	// Max Length: 32
	//
	private	String	bolNumber;

	//
	// Label: Bill To Address
	// Max Length: 255
	//
	private	String	billToAddress;

	//
	// Label: Bill To City
	// Max Length: 50
	//
	private	String	billToCity;

	//
	// Label: Bill To Client Name
	// Max Length: 32
	//
	private	String	billToClientName;

	//
	// Label: Bill To Contact
	// Max Length: 255
	//
	private	String	billToContact;

	//
	// Label: Bill To Phone
	// Max Length: 40
	//
	private	String	billToPhone;

	//
	// Label: Bill To Postal Code
	// Max Length: 10
	//
	private	String	billToPostalCode;

	//
	// Label: Bill To State/Province
	// Max Length: 50
	//
	private	String	billToStateProvince;

	//
	// Label: CI Job Number
	// Max Length: 32
	//
	private	String	ciJobNumber;

	//
	// Label: Carrier Invoice Number
	// Max Length: 32
	//
	private	String	carrierInvoiceNumber;

	//
	// Label: Carrier SCAC
	// Max Length: 10
	//
	private	String	carrierScac;

	//
	// Label: Carrier
	// Max Length: 32
	//
	private	String	carrier;

	//
	// Label: Case Closed
	// Max Length: 1300
	// Read-Only Formula: If(Case__r.IsClosed=true, "yes", "no")
	//
	private	String	caseClosed;

	//
	// Label: Case
	// References: Case
	//
	private	Id	caseId;

	//
	// Label: Client BOL #
	// Max Length: 100
	//
	private	String	clientBol;

	//
	// Label: Client
	// Max Length: 32
	//
	private	String	client;

	//
	// Label: Description
	// Max Length: 255
	//
	private	String	description;

	//
	// Label: Destination Address
	// Max Length: 255
	//
	private	String	destinationAddress;

	//
	// Label: Destination City
	// Max Length: 50
	//
	private	String	destinationCity;

	//
	// Label: Destination Company
	// Max Length: 50
	//
	private	String	destinationCompany;

	//
	// Label: Destination Contact
	// Max Length: 255
	//
	private	String	destinationContact;

	//
	// Label: Destination Phone
	// Max Length: 40
	//
	private	String	destinationPhone;

	//
	// Label: Destination Postal Code
	// Max Length: 10
	//
	private	String	destinationPostalCode;

	//
	// Label: Destination State/Province
	// Max Length: 50
	//
	private	String	destinationStateProvince;

	//
	// Label: Difference (RQ minus EDI)
	// Precision: 10, Scale: 2
	//
	private	BigDecimal	differenceRqMinusEdi;

	//
	// Label: Fuel Surcharge
	// Precision: 10, Scale: 2
	//
	private	BigDecimal	fuelSurcharge;

	//
	// Label: Internal Booked Accessorial Charge
	// Precision: 18, Scale: 2
	// Read-Only Formula: Rate_Quote__r.Accessorial_Price__c
	//
	private	BigDecimal	internalBookedAccessorialCharge;

	//
	// Label: Internal Booked FSC Charge
	// Precision: 18, Scale: 2
	// Read-Only Formula: Rate_Quote__r.FSC_Price__c
	//
	private	BigDecimal	internalBookedFscCharge;

	//
	// Label: Internal Booked Linehaul
	// Precision: 18, Scale: 2
	// Read-Only Formula: Rate_Quote__r.Line_Haul_Price__c
	//
	private	BigDecimal	internalBookedLinehaul;

	//
	// Label: Internal Booked Surcharge
	// Precision: 18, Scale: 2
	// Read-Only Formula: Rate_Quote__r.Surcharge_Price__c
	//
	private	BigDecimal	internalBookedSurcharge;

	//
	// Label: Internal Booked Total Charge
	// Precision: 18, Scale: 2
	// Read-Only Formula: ROUND(Rate_Quote__r.Line_Haul_Price__c, 2) + ROUND(Rate_Quote__r.Surcharge_Price__c, 2) + ROUND(Rate_Quote__r.FSC_Price__c, 2) + ROUND(Rate_Quote__r.Accessorial_Price__c, 2)
	//
	private	BigDecimal	internalBookedTotalCharge;

	//
	// Label: Internal Shipment Accessorial
	// Max Length: 1300
	// Read-Only Formula: Shipment_Accessorial__r.Accessorial__r.Name
	//
	private	String	internalShipmentAccessorial;

	//
	// Label: Invalidated
	// Default: false
	//
	private	Boolean	invalidated;

	//
	// Label: Invoice Line Items
	// Max Length: 32768
	//
	private	String	invoiceLineItems;

	//
	// Label: Invoice Status Id
	// Max Length: 100
	//
	private	String	invoiceStatusId;

	//
	// Label: Invoice
	// References: AccountsReceivable
	//
	private	Id	invoiceId;

	//
	// Label: Linehaul Charge
	// Precision: 10, Scale: 2
	//
	private	BigDecimal	linehaulCharge;

	//
	// Label: Net Amount Due
	// Precision: 10, Scale: 2
	//
	private	BigDecimal	netAmountDue;

	//
	// Label: Notes
	// Max Length: 32768
	//
	private	String	notes;

	//
	// Label: Origin Address
	// Max Length: 255
	//
	private	String	originAddress;

	//
	// Label: Origin City
	// Max Length: 50
	//
	private	String	originCity;

	//
	// Label: Origin Company
	// Max Length: 100
	//
	private	String	originCompany;

	//
	// Label: Origin Contact
	// Max Length: 255
	//
	private	String	originContact;

	//
	// Label: Origin Phone
	// Max Length: 40
	//
	private	String	originPhone;

	//
	// Label: Origin Postal Code
	// Max Length: 10
	//
	private	String	originPostalCode;

	//
	// Label: Origin State/Province
	// Max Length: 50
	//
	private	String	originStateProvince;

	//
	// Label: PO Number
	// Max Length: 200
	//
	private	String	poNumber;

	//
	// Label: PRO#
	// Max Length: 32
	//
	private	String	pro;

	//
	// Label: Parent AP found
	// Default: false
	//
	private	Boolean	parentApFound;

	//
	// Label: Parent Case found
	// Default: false
	//
	private	Boolean	parentCaseFound;

	//
	// Label: Parent Invoice found
	// Default: false
	//
	private	Boolean	parentInvoiceFound;

	//
	// Label: Parent Rate Quote Found
	// Default: false
	//
	private	Boolean	parentRateQuoteFound;

	//
	// Label: Parent Shipment Found
	// Default: false
	//
	private	Boolean	parentShipmentFound;

	//
	// Label: Parent Support Rate Quote Found
	// Default: false
	//
	private	Boolean	parentSupportRateQuoteFound;

	//
	// Label: Potential Rate Quote
	// Max Length: 32
	//
	private	String	potentialRateQuote;

	//
	// Label: Shipment Accessorial
	// References: ShipmentAccessorials
	//
	private	Id	shipmentAccessorialId;

	//
	// Label: Shipment
	// References: Shipment
	//
	private	Id	shipmentId;

	//
	// Label: Status
	// Values: 
	//		Validated
	// Max Length: 255
	//
	private	String	status;

	//
	// Label: Support Rate Quote
	// References: SupportRateQuote
	//
	private	Id	supportRateQuoteId;

	//
	// Label: Surcharge
	// Precision: 10, Scale: 2
	//
	private	BigDecimal	surcharge;

	//
	// Label: Validation Details
	// Max Length: 32768
	//
	private	String	validationDetails;

	//
	// Label: Weight
	// Max Length: 10
	//
	private	String	weight;

	//
	// Label: Exception
	// References: Exception
	//
	private	Id	exceptionId;

	//
	// Label: Accessorial List
	// Max Length: 32768
	//
	private	String	accessorialList;

	//
	// Label: API Reviewed
	// Default: false
	//
	private	Boolean	apiReviewed;

	//
	// Label: Hidden
	// Default: false
	//
	private	Boolean	hidden;


	public InvoiceStatusEdiPOJO () {
		super ();
	}

	public Id getRateQuoteId() {
		 return this.rateQuoteId;
	}

	public void setRateQuoteId (Id rateQuoteId) {
		this.rateQuoteId = rateQuoteId;
	}

	public BigDecimal getAccessorialCharge() {
		 return this.accessorialCharge;
	}

	public void setAccessorialCharge (BigDecimal accessorialCharge) {
		this.accessorialCharge = accessorialCharge;
	}

	public Id getAccountPayableApId() {
		 return this.accountPayableApId;
	}

	public void setAccountPayableApId (Id accountPayableApId) {
		this.accountPayableApId = accountPayableApId;
	}

	public String getActualDeliveryDate() {
		 return this.actualDeliveryDate;
	}

	public void setActualDeliveryDate (String actualDeliveryDate) {
		if (actualDeliveryDate != null && actualDeliveryDate.length() > 20) {
			this.actualDeliveryDate = actualDeliveryDate.substring(0, 20);
		} else {
			this.actualDeliveryDate = actualDeliveryDate;
		}
	}

	public String getActualInvoiceDate() {
		 return this.actualInvoiceDate;
	}

	public void setActualInvoiceDate (String actualInvoiceDate) {
		if (actualInvoiceDate != null && actualInvoiceDate.length() > 20) {
			this.actualInvoiceDate = actualInvoiceDate.substring(0, 20);
		} else {
			this.actualInvoiceDate = actualInvoiceDate;
		}
	}

	public String getActualPickupDate() {
		 return this.actualPickupDate;
	}

	public void setActualPickupDate (String actualPickupDate) {
		if (actualPickupDate != null && actualPickupDate.length() > 20) {
			this.actualPickupDate = actualPickupDate.substring(0, 20);
		} else {
			this.actualPickupDate = actualPickupDate;
		}
	}

	public String getBolNumber() {
		 return this.bolNumber;
	}

	public void setBolNumber (String bolNumber) {
		if (bolNumber != null && bolNumber.length() > 32) {
			this.bolNumber = bolNumber.substring(0, 32);
		} else {
			this.bolNumber = bolNumber;
		}
	}

	public String getBillToAddress() {
		 return this.billToAddress;
	}

	public void setBillToAddress (String billToAddress) {
		if (billToAddress != null && billToAddress.length() > 255) {
			this.billToAddress = billToAddress.substring(0, 255);
		} else {
			this.billToAddress = billToAddress;
		}
	}

	public String getBillToCity() {
		 return this.billToCity;
	}

	public void setBillToCity (String billToCity) {
		if (billToCity != null && billToCity.length() > 50) {
			this.billToCity = billToCity.substring(0, 50);
		} else {
			this.billToCity = billToCity;
		}
	}

	public String getBillToClientName() {
		 return this.billToClientName;
	}

	public void setBillToClientName (String billToClientName) {
		if (billToClientName != null && billToClientName.length() > 32) {
			this.billToClientName = billToClientName.substring(0, 32);
		} else {
			this.billToClientName = billToClientName;
		}
	}

	public String getBillToContact() {
		 return this.billToContact;
	}

	public void setBillToContact (String billToContact) {
		if (billToContact != null && billToContact.length() > 255) {
			this.billToContact = billToContact.substring(0, 255);
		} else {
			this.billToContact = billToContact;
		}
	}

	public String getBillToPhone() {
		 return this.billToPhone;
	}

	public void setBillToPhone (String billToPhone) {
		if (billToPhone != null && billToPhone.length() > 40) {
			this.billToPhone = billToPhone.substring(0, 40);
		} else {
			this.billToPhone = billToPhone;
		}
	}

	public String getBillToPostalCode() {
		 return this.billToPostalCode;
	}

	public void setBillToPostalCode (String billToPostalCode) {
		if (billToPostalCode != null && billToPostalCode.length() > 10) {
			this.billToPostalCode = billToPostalCode.substring(0, 10);
		} else {
			this.billToPostalCode = billToPostalCode;
		}
	}

	public String getBillToStateProvince() {
		 return this.billToStateProvince;
	}

	public void setBillToStateProvince (String billToStateProvince) {
		if (billToStateProvince != null && billToStateProvince.length() > 50) {
			this.billToStateProvince = billToStateProvince.substring(0, 50);
		} else {
			this.billToStateProvince = billToStateProvince;
		}
	}

	public String getCiJobNumber() {
		 return this.ciJobNumber;
	}

	public void setCiJobNumber (String ciJobNumber) {
		if (ciJobNumber != null && ciJobNumber.length() > 32) {
			this.ciJobNumber = ciJobNumber.substring(0, 32);
		} else {
			this.ciJobNumber = ciJobNumber;
		}
	}

	public String getCarrierInvoiceNumber() {
		 return this.carrierInvoiceNumber;
	}

	public void setCarrierInvoiceNumber (String carrierInvoiceNumber) {
		if (carrierInvoiceNumber != null && carrierInvoiceNumber.length() > 32) {
			this.carrierInvoiceNumber = carrierInvoiceNumber.substring(0, 32);
		} else {
			this.carrierInvoiceNumber = carrierInvoiceNumber;
		}
	}

	public String getCarrierScac() {
		 return this.carrierScac;
	}

	public void setCarrierScac (String carrierScac) {
		if (carrierScac != null && carrierScac.length() > 10) {
			this.carrierScac = carrierScac.substring(0, 10);
		} else {
			this.carrierScac = carrierScac;
		}
	}

	public String getCarrier() {
		 return this.carrier;
	}

	public void setCarrier (String carrier) {
		if (carrier != null && carrier.length() > 32) {
			this.carrier = carrier.substring(0, 32);
		} else {
			this.carrier = carrier;
		}
	}

	public String getCaseClosed() {
		 return this.caseClosed;
	}

	protected void setCaseClosed (String caseClosed) {
		if (caseClosed != null && caseClosed.length() > 1300) {
			this.caseClosed = caseClosed.substring(0, 1300);
		} else {
			this.caseClosed = caseClosed;
		}
	}

	public Id getCaseId() {
		 return this.caseId;
	}

	public void setCaseId (Id caseId) {
		this.caseId = caseId;
	}

	public String getClientBol() {
		 return this.clientBol;
	}

	public void setClientBol (String clientBol) {
		if (clientBol != null && clientBol.length() > 100) {
			this.clientBol = clientBol.substring(0, 100);
		} else {
			this.clientBol = clientBol;
		}
	}

	public String getClient() {
		 return this.client;
	}

	public void setClient (String client) {
		if (client != null && client.length() > 32) {
			this.client = client.substring(0, 32);
		} else {
			this.client = client;
		}
	}

	public String getDescription() {
		 return this.description;
	}

	public void setDescription (String description) {
		if (description != null && description.length() > 255) {
			this.description = description.substring(0, 255);
		} else {
			this.description = description;
		}
	}

	public String getDestinationAddress() {
		 return this.destinationAddress;
	}

	public void setDestinationAddress (String destinationAddress) {
		if (destinationAddress != null && destinationAddress.length() > 255) {
			this.destinationAddress = destinationAddress.substring(0, 255);
		} else {
			this.destinationAddress = destinationAddress;
		}
	}

	public String getDestinationCity() {
		 return this.destinationCity;
	}

	public void setDestinationCity (String destinationCity) {
		if (destinationCity != null && destinationCity.length() > 50) {
			this.destinationCity = destinationCity.substring(0, 50);
		} else {
			this.destinationCity = destinationCity;
		}
	}

	public String getDestinationCompany() {
		 return this.destinationCompany;
	}

	public void setDestinationCompany (String destinationCompany) {
		if (destinationCompany != null && destinationCompany.length() > 50) {
			this.destinationCompany = destinationCompany.substring(0, 50);
		} else {
			this.destinationCompany = destinationCompany;
		}
	}

	public String getDestinationContact() {
		 return this.destinationContact;
	}

	public void setDestinationContact (String destinationContact) {
		if (destinationContact != null && destinationContact.length() > 255) {
			this.destinationContact = destinationContact.substring(0, 255);
		} else {
			this.destinationContact = destinationContact;
		}
	}

	public String getDestinationPhone() {
		 return this.destinationPhone;
	}

	public void setDestinationPhone (String destinationPhone) {
		if (destinationPhone != null && destinationPhone.length() > 40) {
			this.destinationPhone = destinationPhone.substring(0, 40);
		} else {
			this.destinationPhone = destinationPhone;
		}
	}

	public String getDestinationPostalCode() {
		 return this.destinationPostalCode;
	}

	public void setDestinationPostalCode (String destinationPostalCode) {
		if (destinationPostalCode != null && destinationPostalCode.length() > 10) {
			this.destinationPostalCode = destinationPostalCode.substring(0, 10);
		} else {
			this.destinationPostalCode = destinationPostalCode;
		}
	}

	public String getDestinationStateProvince() {
		 return this.destinationStateProvince;
	}

	public void setDestinationStateProvince (String destinationStateProvince) {
		if (destinationStateProvince != null && destinationStateProvince.length() > 50) {
			this.destinationStateProvince = destinationStateProvince.substring(0, 50);
		} else {
			this.destinationStateProvince = destinationStateProvince;
		}
	}

	public BigDecimal getDifferenceRqMinusEdi() {
		 return this.differenceRqMinusEdi;
	}

	public void setDifferenceRqMinusEdi (BigDecimal differenceRqMinusEdi) {
		this.differenceRqMinusEdi = differenceRqMinusEdi;
	}

	public BigDecimal getFuelSurcharge() {
		 return this.fuelSurcharge;
	}

	public void setFuelSurcharge (BigDecimal fuelSurcharge) {
		this.fuelSurcharge = fuelSurcharge;
	}

	public BigDecimal getInternalBookedAccessorialCharge() {
		 return this.internalBookedAccessorialCharge;
	}

	protected void setInternalBookedAccessorialCharge (BigDecimal internalBookedAccessorialCharge) {
		this.internalBookedAccessorialCharge = internalBookedAccessorialCharge;
	}

	public BigDecimal getInternalBookedFscCharge() {
		 return this.internalBookedFscCharge;
	}

	protected void setInternalBookedFscCharge (BigDecimal internalBookedFscCharge) {
		this.internalBookedFscCharge = internalBookedFscCharge;
	}

	public BigDecimal getInternalBookedLinehaul() {
		 return this.internalBookedLinehaul;
	}

	protected void setInternalBookedLinehaul (BigDecimal internalBookedLinehaul) {
		this.internalBookedLinehaul = internalBookedLinehaul;
	}

	public BigDecimal getInternalBookedSurcharge() {
		 return this.internalBookedSurcharge;
	}

	protected void setInternalBookedSurcharge (BigDecimal internalBookedSurcharge) {
		this.internalBookedSurcharge = internalBookedSurcharge;
	}

	public BigDecimal getInternalBookedTotalCharge() {
		 return this.internalBookedTotalCharge;
	}

	protected void setInternalBookedTotalCharge (BigDecimal internalBookedTotalCharge) {
		this.internalBookedTotalCharge = internalBookedTotalCharge;
	}

	public String getInternalShipmentAccessorial() {
		 return this.internalShipmentAccessorial;
	}

	protected void setInternalShipmentAccessorial (String internalShipmentAccessorial) {
		if (internalShipmentAccessorial != null && internalShipmentAccessorial.length() > 1300) {
			this.internalShipmentAccessorial = internalShipmentAccessorial.substring(0, 1300);
		} else {
			this.internalShipmentAccessorial = internalShipmentAccessorial;
		}
	}

	public Boolean getInvalidated() {
		 return this.invalidated;
	}

	public void setInvalidated (Boolean invalidated) {
		this.invalidated = invalidated;
	}

	public String getInvoiceLineItems() {
		 return this.invoiceLineItems;
	}

	public void setInvoiceLineItems (String invoiceLineItems) {
		if (invoiceLineItems != null && invoiceLineItems.length() > 32768) {
			this.invoiceLineItems = invoiceLineItems.substring(0, 32768);
		} else {
			this.invoiceLineItems = invoiceLineItems;
		}
	}

	public String getInvoiceStatusId() {
		 return this.invoiceStatusId;
	}

	public void setInvoiceStatusId (String invoiceStatusId) {
		if (invoiceStatusId != null && invoiceStatusId.length() > 100) {
			this.invoiceStatusId = invoiceStatusId.substring(0, 100);
		} else {
			this.invoiceStatusId = invoiceStatusId;
		}
	}

	public Id getInvoiceId() {
		 return this.invoiceId;
	}

	public void setInvoiceId (Id invoiceId) {
		this.invoiceId = invoiceId;
	}

	public BigDecimal getLinehaulCharge() {
		 return this.linehaulCharge;
	}

	public void setLinehaulCharge (BigDecimal linehaulCharge) {
		this.linehaulCharge = linehaulCharge;
	}

	public BigDecimal getNetAmountDue() {
		 return this.netAmountDue;
	}

	public void setNetAmountDue (BigDecimal netAmountDue) {
		this.netAmountDue = netAmountDue;
	}

	public String getNotes() {
		 return this.notes;
	}

	public void setNotes (String notes) {
		if (notes != null && notes.length() > 32768) {
			this.notes = notes.substring(0, 32768);
		} else {
			this.notes = notes;
		}
	}

	public String getOriginAddress() {
		 return this.originAddress;
	}

	public void setOriginAddress (String originAddress) {
		if (originAddress != null && originAddress.length() > 255) {
			this.originAddress = originAddress.substring(0, 255);
		} else {
			this.originAddress = originAddress;
		}
	}

	public String getOriginCity() {
		 return this.originCity;
	}

	public void setOriginCity (String originCity) {
		if (originCity != null && originCity.length() > 50) {
			this.originCity = originCity.substring(0, 50);
		} else {
			this.originCity = originCity;
		}
	}

	public String getOriginCompany() {
		 return this.originCompany;
	}

	public void setOriginCompany (String originCompany) {
		if (originCompany != null && originCompany.length() > 100) {
			this.originCompany = originCompany.substring(0, 100);
		} else {
			this.originCompany = originCompany;
		}
	}

	public String getOriginContact() {
		 return this.originContact;
	}

	public void setOriginContact (String originContact) {
		if (originContact != null && originContact.length() > 255) {
			this.originContact = originContact.substring(0, 255);
		} else {
			this.originContact = originContact;
		}
	}

	public String getOriginPhone() {
		 return this.originPhone;
	}

	public void setOriginPhone (String originPhone) {
		if (originPhone != null && originPhone.length() > 40) {
			this.originPhone = originPhone.substring(0, 40);
		} else {
			this.originPhone = originPhone;
		}
	}

	public String getOriginPostalCode() {
		 return this.originPostalCode;
	}

	public void setOriginPostalCode (String originPostalCode) {
		if (originPostalCode != null && originPostalCode.length() > 10) {
			this.originPostalCode = originPostalCode.substring(0, 10);
		} else {
			this.originPostalCode = originPostalCode;
		}
	}

	public String getOriginStateProvince() {
		 return this.originStateProvince;
	}

	public void setOriginStateProvince (String originStateProvince) {
		if (originStateProvince != null && originStateProvince.length() > 50) {
			this.originStateProvince = originStateProvince.substring(0, 50);
		} else {
			this.originStateProvince = originStateProvince;
		}
	}

	public String getPoNumber() {
		 return this.poNumber;
	}

	public void setPoNumber (String poNumber) {
		if (poNumber != null && poNumber.length() > 200) {
			this.poNumber = poNumber.substring(0, 200);
		} else {
			this.poNumber = poNumber;
		}
	}

	public String getPro() {
		 return this.pro;
	}

	public void setPro (String pro) {
		if (pro != null && pro.length() > 32) {
			this.pro = pro.substring(0, 32);
		} else {
			this.pro = pro;
		}
	}

	public Boolean getParentApFound() {
		 return this.parentApFound;
	}

	public void setParentApFound (Boolean parentApFound) {
		this.parentApFound = parentApFound;
	}

	public Boolean getParentCaseFound() {
		 return this.parentCaseFound;
	}

	public void setParentCaseFound (Boolean parentCaseFound) {
		this.parentCaseFound = parentCaseFound;
	}

	public Boolean getParentInvoiceFound() {
		 return this.parentInvoiceFound;
	}

	public void setParentInvoiceFound (Boolean parentInvoiceFound) {
		this.parentInvoiceFound = parentInvoiceFound;
	}

	public Boolean getParentRateQuoteFound() {
		 return this.parentRateQuoteFound;
	}

	public void setParentRateQuoteFound (Boolean parentRateQuoteFound) {
		this.parentRateQuoteFound = parentRateQuoteFound;
	}

	public Boolean getParentShipmentFound() {
		 return this.parentShipmentFound;
	}

	public void setParentShipmentFound (Boolean parentShipmentFound) {
		this.parentShipmentFound = parentShipmentFound;
	}

	public Boolean getParentSupportRateQuoteFound() {
		 return this.parentSupportRateQuoteFound;
	}

	public void setParentSupportRateQuoteFound (Boolean parentSupportRateQuoteFound) {
		this.parentSupportRateQuoteFound = parentSupportRateQuoteFound;
	}

	public String getPotentialRateQuote() {
		 return this.potentialRateQuote;
	}

	public void setPotentialRateQuote (String potentialRateQuote) {
		if (potentialRateQuote != null && potentialRateQuote.length() > 32) {
			this.potentialRateQuote = potentialRateQuote.substring(0, 32);
		} else {
			this.potentialRateQuote = potentialRateQuote;
		}
	}

	public Id getShipmentAccessorialId() {
		 return this.shipmentAccessorialId;
	}

	public void setShipmentAccessorialId (Id shipmentAccessorialId) {
		this.shipmentAccessorialId = shipmentAccessorialId;
	}

	public Id getShipmentId() {
		 return this.shipmentId;
	}

	public void setShipmentId (Id shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getStatus() {
		 return this.status;
	}

	public void setStatus (String status) {
		if (status != null && status.length() > 255) {
			this.status = status.substring(0, 255);
		} else {
			this.status = status;
		}
	}

	public Id getSupportRateQuoteId() {
		 return this.supportRateQuoteId;
	}

	public void setSupportRateQuoteId (Id supportRateQuoteId) {
		this.supportRateQuoteId = supportRateQuoteId;
	}

	public BigDecimal getSurcharge() {
		 return this.surcharge;
	}

	public void setSurcharge (BigDecimal surcharge) {
		this.surcharge = surcharge;
	}

	public String getValidationDetails() {
		 return this.validationDetails;
	}

	public void setValidationDetails (String validationDetails) {
		if (validationDetails != null && validationDetails.length() > 32768) {
			this.validationDetails = validationDetails.substring(0, 32768);
		} else {
			this.validationDetails = validationDetails;
		}
	}

	public String getWeight() {
		 return this.weight;
	}

	public void setWeight (String weight) {
		if (weight != null && weight.length() > 10) {
			this.weight = weight.substring(0, 10);
		} else {
			this.weight = weight;
		}
	}

	public Id getExceptionId() {
		 return this.exceptionId;
	}

	public void setExceptionId (Id exceptionId) {
		this.exceptionId = exceptionId;
	}

	public String getAccessorialList() {
		 return this.accessorialList;
	}

	public void setAccessorialList (String accessorialList) {
		if (accessorialList != null && accessorialList.length() > 32768) {
			this.accessorialList = accessorialList.substring(0, 32768);
		} else {
			this.accessorialList = accessorialList;
		}
	}

	public Boolean getApiReviewed() {
		 return this.apiReviewed;
	}

	public void setApiReviewed (Boolean apiReviewed) {
		this.apiReviewed = apiReviewed;
	}

	public Boolean getHidden() {
		 return this.hidden;
	}

	public void setHidden (Boolean hidden) {
		this.hidden = hidden;
	}


	public InvoiceStatusEdiPOJO from (TypeMapper tm) {
		super.from (tm);

		this.setRateQuoteId (tm.getId ("Rate_Quote__c"));
		this.setAccessorialCharge (tm.getBigDecimal ("Accessorial_Charge__c"));
		this.setAccountPayableApId (tm.getId ("Account_Payable_AP__c"));
		this.setActualDeliveryDate (tm.getString ("Actual_Delivery_Date__c"));
		this.setActualInvoiceDate (tm.getString ("Actual_Invoice_Date__c"));
		this.setActualPickupDate (tm.getString ("Actual_Pickup_Date__c"));
		this.setBolNumber (tm.getString ("BOL_Number__c"));
		this.setBillToAddress (tm.getString ("Bill_To_Address__c"));
		this.setBillToCity (tm.getString ("Bill_To_City__c"));
		this.setBillToClientName (tm.getString ("Bill_To_Client_Name__c"));
		this.setBillToContact (tm.getString ("Bill_To_Contact__c"));
		this.setBillToPhone (tm.getString ("Bill_To_Phone__c"));
		this.setBillToPostalCode (tm.getString ("Bill_To_Postal_Code__c"));
		this.setBillToStateProvince (tm.getString ("Bill_To_State_Province__c"));
		this.setCiJobNumber (tm.getString ("CI_Job_Number__c"));
		this.setCarrierInvoiceNumber (tm.getString ("Carrier_Invoice_Number__c"));
		this.setCarrierScac (tm.getString ("Carrier_SCAC__c"));
		this.setCarrier (tm.getString ("Carrier__c"));
		this.setCaseClosed (tm.getString ("Case_Closed__c"));
		this.setCaseId (tm.getId ("Case__c"));
		this.setClientBol (tm.getString ("Client_BOL__c"));
		this.setClient (tm.getString ("Client__c"));
		this.setDescription (tm.getString ("Description__c"));
		this.setDestinationAddress (tm.getString ("Destination_Address__c"));
		this.setDestinationCity (tm.getString ("Destination_City__c"));
		this.setDestinationCompany (tm.getString ("Destination_Company__c"));
		this.setDestinationContact (tm.getString ("Destination_Contact__c"));
		this.setDestinationPhone (tm.getString ("Destination_Phone__c"));
		this.setDestinationPostalCode (tm.getString ("Destination_Postal_Code__c"));
		this.setDestinationStateProvince (tm.getString ("Destination_State_Province__c"));
		this.setDifferenceRqMinusEdi (tm.getBigDecimal ("Difference_RQ_minus_EDI__c"));
		this.setFuelSurcharge (tm.getBigDecimal ("Fuel_Surcharge__c"));
		this.setInternalBookedAccessorialCharge (tm.getBigDecimal ("Internal_Booked_Accessorial_Charge__c"));
		this.setInternalBookedFscCharge (tm.getBigDecimal ("Internal_Booked_FSC_Charge__c"));
		this.setInternalBookedLinehaul (tm.getBigDecimal ("Internal_Booked_Linehaul__c"));
		this.setInternalBookedSurcharge (tm.getBigDecimal ("Internal_Booked_Surcharge__c"));
		this.setInternalBookedTotalCharge (tm.getBigDecimal ("Internal_Booked_Total_Charge__c"));
		this.setInternalShipmentAccessorial (tm.getString ("Internal_Shipment_Accessorial__c"));
		this.setInvalidated (tm.getBoolean ("Invalidated__c"));
		this.setInvoiceLineItems (tm.getString ("Invoice_Line_Items__c"));
		this.setInvoiceStatusId (tm.getString ("Invoice_Status_Id__c"));
		this.setInvoiceId (tm.getId ("Invoice__c"));
		this.setLinehaulCharge (tm.getBigDecimal ("Linehaul_Charge__c"));
		this.setNetAmountDue (tm.getBigDecimal ("Net_Amount_Due__c"));
		this.setNotes (tm.getString ("Notes__c"));
		this.setOriginAddress (tm.getString ("Origin_Address__c"));
		this.setOriginCity (tm.getString ("Origin_City__c"));
		this.setOriginCompany (tm.getString ("Origin_Company__c"));
		this.setOriginContact (tm.getString ("Origin_Contact__c"));
		this.setOriginPhone (tm.getString ("Origin_Phone__c"));
		this.setOriginPostalCode (tm.getString ("Origin_Postal_Code__c"));
		this.setOriginStateProvince (tm.getString ("Origin_State_Province__c"));
		this.setPoNumber (tm.getString ("PO_Number__c"));
		this.setPro (tm.getString ("PRO__c"));
		this.setParentApFound (tm.getBoolean ("Parent_AP_found__c"));
		this.setParentCaseFound (tm.getBoolean ("Parent_Case_found__c"));
		this.setParentInvoiceFound (tm.getBoolean ("Parent_Invoice_found__c"));
		this.setParentRateQuoteFound (tm.getBoolean ("Parent_Rate_Quote_Found__c"));
		this.setParentShipmentFound (tm.getBoolean ("Parent_Shipment_Found__c"));
		this.setParentSupportRateQuoteFound (tm.getBoolean ("Parent_Support_Rate_Quote_Found__c"));
		this.setPotentialRateQuote (tm.getString ("Potential_Rate_Quote__c"));
		this.setShipmentAccessorialId (tm.getId ("Shipment_Accessorial__c"));
		this.setShipmentId (tm.getId ("Shipment__c"));
		this.setStatus (tm.getString ("Status__c"));
		this.setSupportRateQuoteId (tm.getId ("Support_Rate_Quote__c"));
		this.setSurcharge (tm.getBigDecimal ("Surcharge__c"));
		this.setValidationDetails (tm.getString ("Validation_Details__c"));
		this.setWeight (tm.getString ("Weight__c"));
		this.setExceptionId (tm.getId ("Exception__c"));
		this.setAccessorialList (tm.getString ("Accessorial_List__c"));
		this.setApiReviewed (tm.getBoolean ("API_Reviewed__c"));
		this.setHidden (tm.getBoolean ("Hidden__c"));

		return this;
	}

	public static Map<String, FieldMetadata> getColumnMap () {
		return columnMap;
	}

	@Override
	public Map<String,FieldMetadata> getMetadata () {
		return InvoiceStatusEdiPOJO.getColumnMap();
	}

	@Override
	public String getObjectName () {
		return "Invoice_Status_EDI__c";
	}
}
