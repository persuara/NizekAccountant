package DocModels;

import Date.Date;

public interface Documentable {
    String payeeName = null;
    String cost = null;
    String description = null;
    Date date = null;

    Date setDate();
}
