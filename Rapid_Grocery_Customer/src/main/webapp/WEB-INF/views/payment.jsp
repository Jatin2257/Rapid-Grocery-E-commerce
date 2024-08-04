<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RazorPay Payment Gateway</title>
</head>
<body>

</body>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
var orderId = "${order}";
var totalAmount = "${amount}"
var options = {
    "key": "rzp_test_AsGtB9UtEEzgrG",
    "amount":totalAmount , //"50000"
    "currency": "INR",
    "name": "Rapid Grocery",
    "description": "Test Transaction",
    "image": "",
    "order_id": orderId,
    "handler": function (response){
        alert(response.razorpay_payment_id);
        alert(response.razorpay_order_id);
        alert(response.razorpay_signature)
    },
    "prefill": {
        "name": "Gaurav Kumar",
        "email": "gaurav.kumar@example.com",
        "contact": "9925293681"
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#3399cc"
    }

};
var rzp1 = new Razorpay(options);
rzp1.on('payment.failed', function (response){
        alert(response.error.code);
        alert(response.error.description);
        alert(response.error.source);
        alert(response.error.step);
        alert(response.error.reason);
        alert(response.error.metadata.order_id);
        alert(response.error.metadata.payment_id);
});

// rzp1.on('payment.cancel', function(){
//     window.location.href = "checkout.jsp"; // Redirect to checkout.jsp when modal is dismissed
// });

rzp1.open();
   

</script>
</html>