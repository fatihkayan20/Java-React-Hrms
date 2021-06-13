import axios from "axios";

export const getGenelDurum = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres", data)
      .then((response) => {
        dispatch({
          type: "GET_GENEL_DURUM",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getHareketTuru = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/hareket", data)
      .then((response) => {
        dispatch({
          type: "GET_HAREKET_TURU",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getAlternatifler = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/alternatifler", data)
      .then((response) => {
        dispatch({
          type: "GET_ALTERNATIFLER",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getHareketListesi = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/hareketlistesi", data)
      .then((response) => {
        dispatch({
          type: "GET_HAREKET_LISTESI",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getSiparisler = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/siparisler", data)
      .then((response) => {
        dispatch({
          type: "GET_SIPARISLER",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getAlimSiparisler = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/alimsiparisler", data)
      .then((response) => {
        dispatch({
          type: "GET_ALIM_SIPARISLER",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getAlimListesi = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/alimlistesi", data)
      .then((response) => {
        dispatch({
          type: "GET_ALIM_LISTESI",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getSatisListesi = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/satislistesi", data)
      .then((response) => {
        dispatch({
          type: "GET_SATIS_LISTESI",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getResimler = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/resimler", data)
      .then((response) => {
        dispatch({
          type: "GET_RESIMLER",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getSozlesmeler = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/sozlesmeler", data)
      .then((response) => {
        dispatch({
          type: "GET_SOZLESMELER",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const getAlternatifEkle = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/alternatifler/sorgu", data)
      .then((response) => {
        dispatch({
          type: "GET_ALTERNATIF_EKLE",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const addStockAlternatif = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/alternatifler/ekle", data)
      .then(() => {
        dispatch({
          type: "ADD_STOCK_ALTERNATİF",
          payload: "Added",
        });
      })
      .catch((err) => {
        dispatch({
          type: "ADD_STOCK_ALTERNATİF",
          payload: "",
        });
      });
  };
};

export const deleteStockAlternatif = (data) => {
  return (dispatch) => {
    axios
      .post("/ekstres/alternatifler/sil", data)
      .then(() => {
        dispatch({
          type: "DELETE_STOCK_ALTERNATİF",
          payload: "Deleted",
        });
      })
      .catch((err) => {
        dispatch({
          type: "DELETE_STOCK_ALTERNATİF",
          payload: "",
        });
      });
  };
};
