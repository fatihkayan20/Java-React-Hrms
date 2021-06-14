import React, { useState } from "react";

export default function Home() {
  const [state, setState] = useState({ posts: [0, 1, 2, 3, 4, 5, 6] });

  const handleClick = () => {
    let newArray = [7, 8, 9, 10];
    setState({
      ...state,
      posts: [...newArray, ...state.posts],
    });
  };
  return (
    <div>
      <input value="Tıkla" onClick={handleClick} />
    </div>
  );
}
