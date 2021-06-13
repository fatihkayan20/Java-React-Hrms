const initialState = {
  genelDurum: [],
  hareketTuru: [],
  alternatifler: [],
  alternatifEkleme: [],
  hareketListesi: [],
  siparisler: [],
  alimSiparisler: [],
  alimListesi: [],
  satisListesi: [],
  resimler: [],
  sozlesmeler: [],
  stockAlternatifAdd: "",
  stockAlternatifDelete: "",
};

const ekstre = (state = initialState, action) => {
  switch (action.type) {
    case "GET_GENEL_DURUM":
      return { ...state, genelDurum: action.payload };

    case "GET_HAREKET_TURU":
      return { ...state, hareketTuru: action.payload };

    case "GET_ALTERNATIFLER":
      return { ...state, alternatifler: action.payload };

    case "GET_HAREKET_LISTESI":
      return { ...state, hareketListesi: action.payload };

    case "GET_SIPARISLER":
      return { ...state, siparisler: action.payload };

    case "GET_ALIM_SIPARISLER":
      return { ...state, alimSiparisler: action.payload };

    case "GET_ALIM_LISTESI":
      return { ...state, alimListesi: action.payload };

    case "GET_SATIS_LISTESI":
      return { ...state, satisListesi: action.payload };

    case "GET_RESIMLER":
      return { ...state, resimler: action.payload };

    case "GET_SOZLESMELER":
      return { ...state, sozlesmeler: action.payload };

    case "GET_ALTERNATIF_EKLE":
      return { ...state, alternatifEkleme: action.payload };

    case "ADD_STOCK_ALTERNATİF":
      return { ...state, stockAlternatifAdd: action.payload };
    case "DELETE_STOCK_ALTERNATİF":
      return { ...state, stockAlternatifDelete: action.payload };
    default:
      return state;
  }
};

export default ekstre;
