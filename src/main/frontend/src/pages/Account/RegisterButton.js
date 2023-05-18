import React, { Component } from "react";

class RegisterButton extends Component {
  state = {
    backgroundColor: "#efefef",
    color: "black",
    border: "solid #efefef 3rem",
  };

  handleClick=()=>{
    const {onClick}=this.props;
    if(onClick){
        onClick();
    }
  }

  handleMouseEnter = () => {
    this.setState({
      backgroundColor: "#008acc",
      color: "white",
      border: "solid #008acc 3rem",
    });
  };

  handleMouseLeave = () => {
    this.setState({
      backgroundColor: "#efefef",
      color: "black",
      border: "solid #efefef 3rem",
    });
  };

  render() {
    const { backgroundColor, color, border } = this.state;
    const { children,id,  } = this.props;

    return (
      <button
        id={id}
        style={{ backgroundColor, color, border }}
        onMouseEnter={this.handleMouseEnter}
        onMouseLeave={this.handleMouseLeave}
        onClick={this.handleClick}
      >
        {children}
      </button>
    );
  }
}

export default RegisterButton;
