import React, { Component } from 'react';

export class UnitListComponent extends Component{
    render(){
        return(
            
                <div>
                  <h1>Units</h1>
          
                  <table>
                    <th>
                      <td>Unit Name</td>
                      <td>Unit ID</td>
                
                    </th>
                    {this.props.units &&
                      this.props.units.map((unit, i) => {
                        return (
                          <tr key={unit.name}>
                           
                            <td>{unit.name}</td>
                            <td>{unit.id}</td>
                          </tr>
                        );
                      })}
                  </table>
                </div>
              )

    }
}