import React from "react";
import { Component } from "react";
import axios from "axios";


class Test extends Component{

  constructor(){
    super();
    this.state = {
      string: ""
    }
  }
  componentDidMount(){
    this.getTest();
  }

  async getTest() {
    const response = await fetch("/api/", {method: "get"})
    return await response;
  }

  render(){
    return(
      <h1>{this.state.string}</h1>
    )
  }

}

export default Test;