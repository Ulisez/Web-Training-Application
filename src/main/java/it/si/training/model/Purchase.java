package it.si.training.model;

/**
 * @Author Sanchez
 * Questa classe è stata creata per modellare l'oggetto "Acquisto"
 */
public class Purchase {

    private Long purchaseId;
    private Long userId; //Id dell'utente che ha effettuato l'acquisto
    private Long carId; //Id dell'auto acquistata dall'utente

    public Purchase() {
    }

    public Purchase(Long userId, Long carId) {
        this.userId = userId;
        this.carId = carId;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}
