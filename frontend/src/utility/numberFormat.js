import React from "react";
import NumberFormat from "react-number-format";

function CustomNumberFormat(props) {
  return (
    <div className="text-right">
      <NumberFormat
        className="number"
        displayType={"text"}
        value={props.value}
        thousandSeparator={true}
        decimalSeparator={"."}
        fixedDecimalScale={true}
        decimalScale={2}
      />
    </div>
  );
}

export default CustomNumberFormat;
