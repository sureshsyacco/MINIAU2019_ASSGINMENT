import React, { Component } from 'react';

import { AddUnitComponent } from './AddUnit.component';
import { UnitListComponent } from './UnitList.component';

export class UnitComponent extends Component {
  
  state = {
    units : [],
  }

  constructor(){
    super();
    this.onAddHandler = this.onAddHandler.bind(this);
  }

  onAddHandler = (data) => {  
    let units = [...this.state.units];
    units.push(data);
    this.setState({
      units: units
    });    
  }

  render() {
    return(  
      <div>
        <h1>UNIT COMPONENT</h1>
        <AddUnitComponent  onAdd={this.onAddHandler} />
        <UnitListComponent units={this.state.units}/>
      </div>
    ); 
  }
} 