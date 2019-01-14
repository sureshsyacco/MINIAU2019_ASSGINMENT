import React, { Component } from 'react';

export class AddUnitComponent extends Component{
    state = {
        formEnabled : false
    }

    constructor(){
        super();
        this.openForm = this.openForm.bind(this);
        this.closeForm = this.closeForm.bind(this);

    }

    openForm = () =>{
        this.setState({
            formEnabled: true
        });
    }

    closeForm = () =>{
        this.setState({
            formEnabled: false
        });
    }
    
    add = e => {
        e.preventDefault();
        this.props.onAdd({
            name: document.getElementById("unit_name").value, 
            id: document.getElementById("unit_id").value, 
            
        })
    }

    render(){
        return(
            <React.Fragment>
                <button onClick = {this.openForm}>Open Form</button>
                {this.state.formEnabled &&
                    <form>
                        <input type='text' id='unit_name' placeholder='Unit Name'/><br/>
                        <input type='text' id="unit_id" placeholder="Unit ID"/><br/>
                        
                        <button onClick = {this.add}>Add Employee</button>
                        <button onClick = {this.closeForm}>Close</button>
                    </form>
                }
            </React.Fragment>
        )
    }
}