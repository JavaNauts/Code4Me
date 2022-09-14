
//import lombok.Data;
//import lombok.SneakyThrows;
//
//import java.net.URI;
//
//@Data
//public class testOrder {
//    private final String orderId;
//    private final URI approvalLink;
//
//    @Override
//    @SneakyThrows
//    public CreatedOrder createOrder(Double totalAmount, URI returnUrl) {
//        final OrderRequest orderRequest = createOrderRequest(totalAmount, returnUrl);
//        final OrdersCreateRequest ordersCreateRequest = new OrdersCreateRequest().requestBody(orderRequest);
//        final HttpResponse<Order> orderHttpResponse = payPalHttpClient.execute(ordersCreateRequest);
//        final Order order = orderHttpResponse.result();
//        LinkDescription approveUri = extractApprovalLink(order);
//        return new CreatedOrder(order.id(),URI.create(approveUri.href()));
//    }
//
//    private OrderRequest createOrderRequest(Double totalAmount, URI returnUrl) {
//        final OrderRequest orderRequest = new OrderRequest();
//        setCheckoutIntent(orderRequest);
//        setPurchaseUnits(totalAmount, orderRequest);
//        setApplicationContext(returnUrl, orderRequest);
//        return orderRequest;
//    }
//
//    private OrderRequest setApplicationContext(URI returnUrl, OrderRequest orderRequest) {
//        return orderRequest.applicationContext(new ApplicationContext().returnUrl(returnUrl.toString()));
//    }
//
//    private void setPurchaseUnits(Double totalAmount, OrderRequest orderRequest) {
//        final PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest()
//                .amountWithBreakdown(new AmountWithBreakdown().currencyCode("USD").value(totalAmount.toString()));
//        orderRequest.purchaseUnits(Arrays.asList(purchaseUnitRequest));
//    }
//
//    private void setCheckoutIntent(OrderRequest orderRequest) {
//        orderRequest.checkoutPaymentIntent("CAPTURE");
//    }
//
//    private LinkDescription extractApprovalLink(Order order) {
//        LinkDescription approveUri = order.links().stream()
//                .filter(link -> APPROVE_LINK_REL.equals(link.rel()))
//                .findFirst()
//                .orElseThrow(NoSuchElementException::new);
//        return approveUri;
//    }
//
//}
