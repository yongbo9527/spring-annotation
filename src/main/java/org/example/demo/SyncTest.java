//package test;
//
///**
// * @Author: Ron
// * @Create: 2024-03-07 19:18
// */
//class LazyinitDemo {
//    private static TransactionService service = null;
//
//    public static TransactionService getTransactionService() {
//
//        if (service == null) {
//            synchronized (this) {
//                if (service == null) {
//                    service = new TransactionService();
//                }
//            }
//        }
//        return service;
//    }
//}